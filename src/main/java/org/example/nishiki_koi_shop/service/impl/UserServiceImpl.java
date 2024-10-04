package org.example.nishiki_koi_shop.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.example.nishiki_koi_shop.model.entity.User;
import org.example.nishiki_koi_shop.repository.UserRepository;
import org.example.nishiki_koi_shop.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@Log4j2
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void softDeleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setDeletedAt(LocalDate.now());  // Đánh dấu thời gian xóa
        userRepository.save(user);
    }
    public void restoreUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setDeletedAt(null);  // Khôi phục người dùng
        userRepository.save(user);
    }

}
