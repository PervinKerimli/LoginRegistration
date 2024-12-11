package com.SpringSecurity.LoginRegistration.Repository;

import com.SpringSecurity.LoginRegistration.EntityOrModel.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles,Long> {
    Roles findByEmail(String name);
}
