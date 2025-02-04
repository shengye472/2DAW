package com.fpmislata.exam.common.validation;

import com.fpmislata.exam.common.validation.annotation.ValidYear;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class YearValidator implements ConstraintValidator<ValidYear, Integer> {

    @Override
    public void initialize(ValidYear constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext constraintValidatorContext) {
        return year != null && year >= 1900;
    }
}
