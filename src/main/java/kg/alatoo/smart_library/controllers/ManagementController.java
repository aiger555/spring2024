package kg.alatoo.smart_library.controllers;

import kg.alatoo.smart_library.dto.BookCheckOut;
import kg.alatoo.smart_library.dto.BookOverDueDto;
import kg.alatoo.smart_library.dto.BookReturnDto;
import kg.alatoo.smart_library.dto.SuccessDto;
import kg.alatoo.smart_library.services.ManagementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management")
@RequiredArgsConstructor
public class ManagementController {

    @Autowired
    private ManagementService managementService;

    @PostMapping("/check-out-book")
    public SuccessDto checkOutBook(@RequestBody BookCheckOut bookCheckOut){
        return new SuccessDto(managementService.checkOutUser(bookCheckOut));
    }

    @PostMapping("/return-book")
    public BookOverDueDto returnBook(@RequestBody BookReturnDto bookReturnDto){
        return managementService.returnBook(bookReturnDto);
    }

}