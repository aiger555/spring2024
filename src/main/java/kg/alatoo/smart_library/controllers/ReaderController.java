package kg.alatoo.smart_library.controllers;

import kg.alatoo.smart_library.dto.ReaderDto;
import kg.alatoo.smart_library.entities.ReaderEntity;
import kg.alatoo.smart_library.repositories.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/readers/")
public class ReaderController {

    @Autowired
    private ReaderRepository readerRepository;

    @GetMapping("/get-all")
    public List<ReaderEntity> getAll(@RequestParam(value = "name", required = false) String name) {
        if (name != null){
            return readerRepository.findAllByFullNameContainingIgnoreCase(name);
        }else {
            return readerRepository.findAll();
        }
    }

    @PostMapping("/create")
    public ReaderEntity create(@RequestBody ReaderEntity readerEntity) {
        return readerRepository.save(readerEntity);
    }

    @PutMapping("/update/{id}")
    public ReaderEntity update(@RequestBody ReaderDto readerDto, @PathVariable Long id) {
        ReaderEntity toUpdate = readerRepository.findById(id).get();
        if (readerDto.getFullName() != null){
            toUpdate.setFullName(readerDto.getFullName());
        }
        if (readerDto.getEmail() != null) {
            toUpdate.setEmail(readerDto.getEmail());
        }
        if (readerDto.getPassportNumber() != null){
            toUpdate.setPassportNumber(readerDto.getPassportNumber());
        }
        if (readerDto.getPhoneNumber() != null) {
            toUpdate.setPhoneNumber(readerDto.getPhoneNumber());
        }

        toUpdate.setModifiedAt(LocalDateTime.now());
        return readerRepository.save(toUpdate);
    }

}