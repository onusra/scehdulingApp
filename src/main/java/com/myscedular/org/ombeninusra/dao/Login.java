package com.myscedular.org.ombeninusra.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Login {
    String email;
    String password;
}
