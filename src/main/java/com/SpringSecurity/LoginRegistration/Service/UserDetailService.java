package com.SpringSecurity.LoginRegistration.Service;

import com.SpringSecurity.LoginRegistration.EntityOrModel.User;
import com.SpringSecurity.LoginRegistration.EntityOrModel.UserPrincipal;
import com.SpringSecurity.LoginRegistration.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


@AllArgsConstructor
public class UserDetailService implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user==null){
            System.out.println("User is not found");
            throw new UsernameNotFoundException("User is not found");
        }
        return new UserPrincipal(user);
    }
}
