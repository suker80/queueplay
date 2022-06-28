package com.example.queueplay.user;

import com.example.queueplay.user.dto.UserLoginSuccessResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User UserLoginSuccessDtoToUser(UserLoginSuccessResponse userLoginSuccessResponse);

    UserLoginSuccessResponse userToUserLoginSuccessDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUserLoginSuccessDto(UserLoginSuccessResponse userLoginSuccessResponse, @MappingTarget User user);
}
