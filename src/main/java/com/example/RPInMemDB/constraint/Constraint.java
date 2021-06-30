package com.example.RPInMemDB.constraint;

import java.util.Objects;

public interface Constraint {
    boolean constraintCheck(String value);
}
