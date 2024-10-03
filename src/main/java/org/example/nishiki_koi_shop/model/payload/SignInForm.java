package org.example.nishiki_koi_shop.model.payload;

import lombok.Data;

@Data
public class SignInForm {
    private String email;
    private String password;
}