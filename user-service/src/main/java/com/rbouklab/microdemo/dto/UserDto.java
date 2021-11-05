package com.rbouklab.microdemo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {
    private String code;
    private String firstName;
    private String lastName;
    private String email;
}
