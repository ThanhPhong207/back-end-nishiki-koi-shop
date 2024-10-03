package org.example.nishiki_koi_shop.service;

import org.example.nishiki_koi_shop.model.dto.AuthDto;
import org.example.nishiki_koi_shop.model.payload.SignInForm;
import org.example.nishiki_koi_shop.model.payload.SignUpForm;

public interface AuthService {
    AuthDto login(SignInForm form);
    String register(SignUpForm form);
    AuthDto refreshJWT(String refreshToken);
}