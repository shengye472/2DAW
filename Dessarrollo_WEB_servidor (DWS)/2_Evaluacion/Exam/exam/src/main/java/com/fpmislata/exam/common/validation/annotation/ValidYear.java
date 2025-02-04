package com.fpmislata.exam.common.validation.annotation;

import com.fpmislata.exam.common.validation.YearValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = YearValidator.class)
public @interface ValidYear {
    String message() default "El año debe ser posterior a 1880";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
