package com.example.demo.validators;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 *
 *
 *
 */
public class MaxProductsValidator implements ConstraintValidator<ValidMaxProducts, Product> {
    @Autowired
    private ApplicationContext context;
    public static  ApplicationContext myContext;
    @Override
    public void initialize(ValidMaxProducts constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Product product, ConstraintValidatorContext constraintValidatorContext) {
        if (context == null) return true;
        if (context != null) myContext = context;
        ProductService repo = myContext.getBean(ProductServiceImpl.class);

        if (product.getInv() > 50) {
            // display exceeds max inv error message
            constraintValidatorContext.buildConstraintViolationWithTemplate("Product inventory cannot exceed maximum of 50.").addConstraintViolation();
            return false;
        }

        else {
            return true;
        }
    }
}
