package com.SpringSecurity.LoginRegistration.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
private long ID;
private String name;
private String password;
private String email;

}
