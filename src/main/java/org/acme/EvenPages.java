package org.acme;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EvenPagesValidator.class)
public @interface EvenPages {
    String message() default "Number of pages must be even";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}