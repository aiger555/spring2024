package kg.alatoo.smart_library.controllers;

import jakarta.validation.Valid;
import kg.alatoo.smart_library.dto.SignUpDto;
import kg.alatoo.smart_library.dto.SuccessDto;
import kg.alatoo.smart_library.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trusted/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public SuccessDto signUp(@Valid @RequestBody SignUpDto signUpDto){
        userService.saveUser(signUpDto);
        return SuccessDto.builder().success(true).build();
    }

}