package com.SpringSecurity.LoginRegistration.Controller;

import com.SpringSecurity.LoginRegistration.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthController {
    @Autowired
    private final UserService userService;

}
