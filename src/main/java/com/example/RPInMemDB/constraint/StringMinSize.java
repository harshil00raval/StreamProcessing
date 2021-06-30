package com.example.RPInMemDB.constraint;

import java.util.Objects;

public class StringMinSize implements Constraint{

    private final int size;
    public StringMinSize(int size){
        this.size = size;
    }

    public boolean constraintCheck(String value){
        return Objects.nonNull(value) && value.length()>=size
                ? Boolean.TRUE
                : Boolean.FALSE;
    }
}
