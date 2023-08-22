package com.supercoding.commerce03.web.dto.user;

import com.supercoding.commerce03.repository.user.entity.User;
import com.supercoding.commerce03.repository.user.entity.UserDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUp {
    private String userName;
    private String password;
    private String address;
    private String detailAddress;
    private String phoneNumber;
    private String email;

}