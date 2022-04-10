package com.example.queueplay.user;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UserMapper {
    User UserLoginSuccessDtoToUser(UserLoginSuccessDto userLoginSuccessDto);

    UserLoginSuccessDto userToUserLoginSuccessDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromUserLoginSuccessDto(UserLoginSuccessDto userLoginSuccessDto, @MappingTarget User user);
}
