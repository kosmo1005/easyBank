package com.cool_company.easy_bank.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class ValidationErrorResponse {
    private List<String> errors;
}
