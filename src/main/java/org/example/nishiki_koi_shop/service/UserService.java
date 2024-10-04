package org.example.nishiki_koi_shop.service;

public interface UserService {
    public void softDeleteUser(Long userId);
    public void restoreUser(Long userId);
}
