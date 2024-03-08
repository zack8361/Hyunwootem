package com.hyunwootem.hyunwootemproject.dto.request;


import lombok.Data;

@Data
public class RegisterRequestDto {
    private String email;
    private String name;
    private String password;
}
