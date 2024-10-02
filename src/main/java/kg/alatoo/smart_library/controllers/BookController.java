package kg.alatoo.smart_library.controllers;

import kg.alatoo.smart_library.entities.BookEntity;
import kg.alatoo.smart_library.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/get-all")
    public List<BookEntity> getAll() {
        return bookRepository.findAll();
    }

    @PostMapping("create")
    public BookEntity create(@RequestBody BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    @PutMapping("update/{id}")
    public BookEntity update(@RequestBody BookUpdateDto book, @PathVariable("id") Long id) {
        BookEntity toUpdate = bookRepository.findById(id).get();
        if (book.getName() != null) {
            toUpdate.setName(book.getName());
        }
        if (book.getAuthor() != null) {
            toUpdate.setAuthor(book.getAuthor());
        }
        if (book.getGenre() != null) {
            toUpdate.setGenre(book.getGenre());
        }
        if (book.getReleasedYear() != null) {
            toUpdate.setReleasedYear(book.getReleasedYear());
        }
        return bookRepository.save(toUpdate);
    }

    @DeleteMapping("delete/{id}")
    public SuccessDto delete(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return new SuccessDto(true);
    }

}
