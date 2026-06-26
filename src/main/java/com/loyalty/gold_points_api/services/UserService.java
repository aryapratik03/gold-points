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

    public List<UserResponse> getAllUsers(){
        return userRepository.findAll().stream().map(this::toResponse).toList();
    }
    public UserResponse createUser(UserRequest userRequest){
        User user = new User();
        user.setFullName(userRequest.fullName());
        user.setEmail(userRequest.email());
        user.setPassword(userRequest.password()); //TODO Create hmac for password and save encrypted

        User savedUser = userRepository.save(user);

        return toResponse(savedUser);
    }
    private UserResponse toResponse(User user) {
        return new UserResponse(user.getUserId(), user.getFullName(), user.getEmail());
    }

}
