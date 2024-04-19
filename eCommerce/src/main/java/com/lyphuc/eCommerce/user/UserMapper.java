package com.lyphuc.eCommerce.user;

public class UserMapper {
    public static UserDto mapToUserDto(UserEntity user){
        UserDto userDto = UserDto.builder()
                .userId(user.getUserId())
                .firstName(user.getFirstName())
                .registrationDate(user.getRegistrationDate())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .lastName(user.getLastName())
                .address(user.getAddress())
                .build();
        return userDto;
    }
    public static UserEntity mapToUser(UserDto userDto){
        UserEntity user = UserEntity.builder()
                .userId(userDto.getUserId())
                .firstName(userDto.getFirstName())
                .registrationDate(userDto.getRegistrationDate())
                .phoneNumber(userDto.getPhoneNumber())
                .email(userDto.getEmail())
                .lastName(userDto.getLastName())
                .address(userDto.getAddress())
                .build();
        return user;
    }
}
