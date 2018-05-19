package com.example02.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({TYPE, METHOD, FIELD, PARAMETER})
public @interface DomainArea {


    int AREA_A = 1;
    int AREA_B = 2;
    int AREA_C = 3;
    int AREA_D = 4;

    int[] value();
}
