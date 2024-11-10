package com.mihnea.album_recom_api.dto;

import lombok.Data;

@Data
public class RegistrationDto {
    private Integer user_id;
    private String username;
    private String password;
    private String email;
}
