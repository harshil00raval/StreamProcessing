package com.example.RPInMemDB.imschema;

import com.example.RPInMemDB.imtable.Table;
import com.example.RPInMemDB.imtable.TableSimple;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SchemaSimple implements Schema{
    private Map<String, Table> tableMap = new HashMap<>();

    /*
    args format sample
    employee, <empid|intr, <NOTNULL, 0>> , <empName|str, <>>>>
     */
    @Override public Boolean createTable(String tableName, Map<String, Map<String, Integer>> columnMap) {
        Table table = new TableSimple();
        for(Map.Entry<String, Map<String, Integer>> col : columnMap.entrySet()){
            table.addColumn(col.getKey(), col.getValue());
        }
        tableMap.put(tableName, table);
        return tableMap.containsKey(tableName);
    }

    @Override public Boolean deleteTable(String tableName) {
        tableMap.remove(tableName);
        return! tableMap.containsKey(tableName);
    }

    public Table getTable(String tableName){
        return tableMap.get(tableName);
    }
}
