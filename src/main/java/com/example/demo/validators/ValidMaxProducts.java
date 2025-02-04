package com.example.demo.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 *
 *
 *
 */
@Constraint(validatedBy = {MaxProductsValidator.class})
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMaxProducts {
    String message() default "Too many products to be added";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};

}
