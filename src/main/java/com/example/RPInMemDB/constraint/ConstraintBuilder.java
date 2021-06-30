package com.example.RPInMemDB.constraint;

public class ConstraintBuilder {

    public static NotNullConstraint notNullConstraint = new NotNullConstraint();
    public static EmptyConstraint emptyConstraint = new EmptyConstraint();

    public static Constraint buildConstraint(String Name, Integer value){
        if("NOTNULL".equals(Name))
            return notNullConstraint;
        if("STRMINSIZE".equals(Name))
            return new StringMinSize(value);

        return emptyConstraint;
    }
}
