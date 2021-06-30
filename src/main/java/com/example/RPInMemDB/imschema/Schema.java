package com.example.RPInMemDB.imschema;

import com.example.RPInMemDB.imtable.Table;

import java.util.Map;

public interface Schema {

    Boolean createTable(String tableName, Map<String, Map<String, Integer>> columnMap);
    Boolean deleteTable(String tableName);
    Table getTable(String tableName);
    // listOfConstraints() //futurescope
}
