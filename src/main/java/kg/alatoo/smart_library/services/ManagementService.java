package kg.alatoo.smart_library.services;

import kg.alatoo.smart_library.dto.BookCheckOut;
import kg.alatoo.smart_library.dto.BookOverDueDto;
import kg.alatoo.smart_library.dto.BookReturnDto;
import kg.alatoo.smart_library.entities.BookEntity;
import kg.alatoo.smart_library.entities.ReaderEntity;
import kg.alatoo.smart_library.repositories.BookRepository;
import kg.alatoo.smart_library.repositories.ReaderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManagementService {

    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;


    public boolean checkOutUser(BookCheckOut bookCheckOut) {
        BookEntity book = bookRepository.findById(bookCheckOut.getBookId()).orElseThrow();
        ReaderEntity reader = readerRepository.findById(bookCheckOut.getReaderId()).orElseThrow();
        if (book.getReader() != null) {
            throw new RuntimeException();
        }
        book.setReader(reader);
        book.setReturnDate(LocalDateTime.now().plusDays(bookCheckOut.getPeriodDays()));
        bookRepository.save(book);
        return true;
    }

    public BookOverDueDto returnBook(BookReturnDto bookReturnDto) {
        BookOverDueDto bookOverDueDto = new BookOverDueDto();
        BookEntity book = bookRepository.findById(bookReturnDto.getBookId()).orElseThrow();

        Duration overdue = Duration.between(book.getReturnDate(), LocalDateTime.now());

        String overDuePeriod = "Days: " +
                overdue.toDays() +
                ", Hours: " +
                overdue.toHoursPart() +
                ", Minutes: " +
                overdue.toMinutesPart();

        bookOverDueDto.setOverduePeriod(overDuePeriod);
        bookOverDueDto.setOverdue(LocalDateTime.now().isAfter(book.getReturnDate()));

        book.setReturnDate(null);
        book.setReader(null);

        bookRepository.save(book);
        return bookOverDueDto;
    }
}