package com.example.RPInMemDB.constraint;

import java.util.Objects;

public class NotNullConstraint implements  Constraint{

    public boolean constraintCheck(String value){
        return Objects.isNull(value);
    }
}
