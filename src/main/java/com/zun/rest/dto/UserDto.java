package com.zun.rest.dto;

import com.zun.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private int gender_id;
    private String email;

    private int role;

    public static User toDomainObject(UserDto userDto) {
        return new User(userDto.getId(), userDto.getName(),userDto.getGender_id(),userDto.getEmail(),"",userDto.getRole());
    }

    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(),user.getGender_id(),user.getEmail(),user.getRole());
    }
}

