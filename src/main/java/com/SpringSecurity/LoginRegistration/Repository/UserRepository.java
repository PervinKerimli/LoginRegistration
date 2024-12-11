package com.SpringSecurity.LoginRegistration.Repository;

import com.SpringSecurity.LoginRegistration.EntityOrModel.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);

}
