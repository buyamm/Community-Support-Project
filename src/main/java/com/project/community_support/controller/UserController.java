package com.project.community_support.controller;

import com.project.community_support.dto.request.UserCreationRequest;
import com.project.community_support.dto.request.UserUpdateRequest;
import com.project.community_support.dto.response.ApiResponse;
import com.project.community_support.dto.response.UserResponse;
import com.project.community_support.entity.User;
import com.project.community_support.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request){
        ApiResponse<UserResponse> apiResponse = new ApiResponse<>();

        apiResponse.setCode(1000);
        apiResponse.setResult(userService.createUser(request));

        return apiResponse;
    }

    @GetMapping
    ApiResponse<List<UserResponse>> getAllUsers(){
        return ApiResponse.<List<UserResponse>>builder()
                .result(userService.getAllUser())
                .build();
    }

    @GetMapping("/{userId}")
    ApiResponse<UserResponse> getUser(@PathVariable String userId){
        return ApiResponse.<UserResponse>builder()
                .result(userService.getUser(userId))
                .build();
    }

    @PutMapping("{userId}")
    ApiResponse<UserResponse> updateUser(@RequestBody UserUpdateRequest request, @PathVariable("userId") String userId) {
        return ApiResponse.<UserResponse>builder()
                .result(userService.updateUser(request, userId))
                .build();
    }

    @DeleteMapping("{userId}")
    ApiResponse<String> deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(userId);
        return ApiResponse.<String>builder()
                .result("User has been deleted")
                .build();
    }




}
