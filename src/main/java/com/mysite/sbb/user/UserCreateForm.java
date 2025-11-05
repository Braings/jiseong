package com.mysite.sbb.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    @Size(min = 3, max = 25)
    @NotEmpty(message = "User ID can not be Empty.")
    private String username;

    @NotEmpty(message = "Password can not be Empty.")
    private String password1;

    @NotEmpty(message = "Please confirm your Password.")
    private String password2;

    @NotEmpty(message = "E-mail can not be Empty.")
    @Email
    private String email;
}