package org.example.nishiki_koi_shop.model.payload;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SignUpForm {
    private String email;
    private String password;
    private String confirmPassword;
    private String username;
}