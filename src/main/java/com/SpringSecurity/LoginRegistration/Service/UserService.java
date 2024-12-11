package com.SpringSecurity.LoginRegistration.Service;

import com.SpringSecurity.LoginRegistration.DTO.UserDTO;
import com.SpringSecurity.LoginRegistration.EntityOrModel.User;
import java.util.List;

public interface UserService {
    User register(UserDTO userdto);

    User findByEmail(String email);

    List<UserDTO> findAllUser();

    String verify(User user);

}
