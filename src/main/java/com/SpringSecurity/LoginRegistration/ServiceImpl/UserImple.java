package com.SpringSecurity.LoginRegistration.ServiceImpl;

import com.SpringSecurity.LoginRegistration.DTO.UserDTO;
import com.SpringSecurity.LoginRegistration.EntityOrModel.User;
import com.SpringSecurity.LoginRegistration.Repository.RolesRepository;
import com.SpringSecurity.LoginRegistration.Repository.UserRepository;
import com.SpringSecurity.LoginRegistration.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserImple implements UserService {

    private RolesRepository rolesRepository;
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authManager;



    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDTO> findAllUser() {
       List<User> users = userRepository.findAll();
        if(users==null || users.isEmpty()){
            return Collections.emptyList();
        }
        return users.stream()
                .map(this::mapToUserDTO)
                .collect(Collectors.toList());
    }


    @Override
    public User register(UserDTO userDTO) {
        User user = User.builder()
                .username(userDTO.getName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .build();
        return userRepository.save(user);
    }

    @Override
    public String verify(User user) {
        try {
            Authentication authentication =authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
            if(authentication.isAuthenticated()){
                return "succes";
            }
        } catch (AuthenticationException e) {
            return "fail " + e.getMessage();
        }
        return "Fail ";
    }

    private UserDTO mapToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        String[] str = user.getUsername().split(" ");
        userDTO.setName(str[0]);
        userDTO.setPassword(str[1]);
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }
}
