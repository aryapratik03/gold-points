package com.loyalty.gold_points_api.services;

import com.loyalty.gold_points_api.dto.request.UserRequest;
import com.loyalty.gold_points_api.dto.response.UserResponse;
import com.loyalty.gold_points_api.entities.User;
import com.loyalty.gold_points_api.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository ;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public User findUserById(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserResponse createUser(UserRequest userRequest) {
        User user = User.builder()
                .fullName(userRequest.fullName())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();

        User savedUser = userRepository.save(user);
        return toResponse(savedUser);
    }

    public UserResponse toResponse(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getFullName(),
                user.getEmail()
        );
    }
}