package com.project.community_support.mapper;

import com.project.community_support.dto.request.UserCreationRequest;
import com.project.community_support.dto.request.UserUpdateRequest;
import com.project.community_support.dto.response.UserResponse;
import com.project.community_support.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserCreationRequest request);

    void updateUser(@MappingTarget User user, UserUpdateRequest request);

    UserResponse toUserResponse(User user);
}


