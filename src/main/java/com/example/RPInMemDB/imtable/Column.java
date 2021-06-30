package com.example.RPInMemDB.imtable;

import com.example.RPInMemDB.constraint.Constraint;
import com.example.RPInMemDB.constraint.ConstraintBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Column {

    private final String columnName;
    private final ColumnType columnType;
    private final List<Constraint> constraintList;

    public Column(String columnName, String columnType, Map<String, Integer> constraints){
        this.columnName = columnName;
        this.columnType = ColumnType.valueOf(columnType);
        this.constraintList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : constraints.entrySet()){
            constraintList.add(ConstraintBuilder.buildConstraint(entry.getKey(), entry.getValue()));
        }
    }

    public boolean constraintCheck(String value){
        for(Constraint constraint : constraintList){
            if(!constraint.constraintCheck(value))
                return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

}
