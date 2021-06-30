package com.example.RPInMemDB;

import com.example.RPInMemDB.imschema.Schema;
import com.example.RPInMemDB.imschema.SchemaSimple;
import com.example.RPInMemDB.imtable.Table;

import java.util.HashMap;
import java.util.Map;

public class InMemDBTesting {

    public static void main(String[] args) {

        Schema schema = new SchemaSimple();

        Map<String, Map<String, Integer>> columnMap = new HashMap<>();

        String empid = "empID-inte";
        Map<String, Integer> constraintsEmpId = new HashMap<>();
        constraintsEmpId.put("NOTNULL", 0);

        String empName = "empName-str";
        Map<String, Integer> constraintsempName = new HashMap<>();
        constraintsempName.put("NOTNULL",0);
        constraintsempName.put("STRMINSIZE", 10);


        String dept = "dept-str";
        Map<String, Integer> constraintsDept = new HashMap<>();

        String addr = "addr-str";
        Map<String, Integer> constraintsAddr = new HashMap<>();

        columnMap.put(empid, constraintsEmpId);
        columnMap.put(empName, constraintsempName);
        columnMap.put(dept, constraintsDept);
        columnMap.put(addr, constraintsAddr);

        schema.createTable("emp", columnMap);

        Table table = schema.getTable("emp");

        System.out.println(table);


        //Map<String, String> values
        Map<String, String> values = new HashMap<>();
        values.put("empID", "1");
        values.put("empName", "abc");
        values.put("dept", "x");
        table.insert(values);

        Map<String, String> values1 = new HashMap<>();
        values1.put("empID", "2");
        values1.put("empName", "abcd");
        values1.put("dept", "x");
        table.insert(values1);

        Map<String, String> values2 = new HashMap<>();
        values2.put("empID", "3");
        values2.put("empName", "abcde");
        values2.put("dept", "x");
        table.insert(values2);

        Map<String, String> values3 = new HashMap<>();
        values3.put("empID", "4");
        values3.put("empName", "ab");
        values3.put("dept", "x");
        values3.put("addr", "Bangalore");
        table.insert(values3);

        table.printAll();

        System.out.println(schema.deleteTable("emp"));

        System.out.println(schema);

    }
}
