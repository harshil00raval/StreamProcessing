package com.example.RPInMemDB.constraint;

import java.util.Objects;

public class EmptyConstraint implements  Constraint{

    public boolean constraintCheck(String value){
        return Boolean.TRUE;
    }
}
