package com.project.community_support.service;

import com.project.community_support.dto.request.UserCreationRequest;
import com.project.community_support.dto.request.UserUpdateRequest;
import com.project.community_support.dto.response.UserResponse;
import com.project.community_support.entity.User;
import com.project.community_support.exception.AppException;
import com.project.community_support.exception.ErrorCode;
import com.project.community_support.mapper.UserMapper;
import com.project.community_support.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public UserResponse createUser(UserCreationRequest request) {
        if (userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }

//        no encryption for password yet
        User user = userMapper.toUser(request);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    public UserResponse getUser(String userId) {
        return userMapper.toUserResponse(userRepository.findById(userId).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_FOUND)
        ));
    }

    public List<UserResponse> getAllUser() {
        return userRepository.findAll().stream().map(user -> userMapper.toUserResponse(user)).toList();
    }

    public UserResponse updateUser(UserUpdateRequest request, String userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new AppException(ErrorCode.USER_NOT_FOUND)
        );

        userMapper.updateUser(user, request);

        return userMapper.toUserResponse(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }
}
