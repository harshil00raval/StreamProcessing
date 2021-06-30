package com.example.RPInMemDB.imtable;

import java.util.Map;

public interface Table {

    void addColumn(String colDef, Map<String, Integer> constraints);
    boolean insert(Map<String, String> values);
    void printAll();
    void printFiltered(String column_name, String Value);
    boolean constraintCheck(Map<String, String> values);

}
