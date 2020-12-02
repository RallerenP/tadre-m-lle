package com.mchg.tadremoelle.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class AddUserDTO {
    @NotEmpty()
    @Length(min=3, max=20)
    private String username;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", message = "Password must be: min. 8 characters, contain atleast 1 letter and 1 number")
    private String password;

    @Pattern(regexp = "^\\S+@\\S+\\.\\S+$", message = "Very invalid email")
    private String email;

}
