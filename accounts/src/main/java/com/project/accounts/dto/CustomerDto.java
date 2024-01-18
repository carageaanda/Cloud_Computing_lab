package com.project.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CustomerDto {

    private String name;

    private String email;

    private String mobileNumber;

    private AccountsDto accountsDto;

}
