package com.example.RPInMemDB.imtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class TableSimple implements Table{

    private List<Column> columns = new ArrayList<>();

    //storing all info in string for the time being
    //we'll parse only before constraint check
    private Map<String, List<String>> listOfColumns = new HashMap();
    List<List<String>> columnsList = new ArrayList<>();

    @Override public void addColumn(String colDef,
            Map<String, Integer> constraints) {
        String[] colInfo = colDef.split("-");
        Column column = new Column(colInfo[0], colInfo[1], constraints);
        columns.add(column);
        List<String> col = new ArrayList<>();
        listOfColumns.put(colInfo[0], col);
        columnsList.add(col);

        /* todo : if column is being added in existing table then please populate
            default values in new array list for prev entries
         */
    }

    @Override public boolean insert(Map<String, String> values) {
        //constraint check on all values

        if(constraintCheck( values)) {
            for (Map.Entry<String, String> entry : values.entrySet()) {
                listOfColumns.get(entry.getKey()).add(entry.getValue());
            }
            //for each array list where we do not have mapping insert "null"
            for(Map.Entry<String, List<String>> entry : listOfColumns.entrySet()){
                if(!values.keySet().contains(entry.getKey())){
                    entry.getValue().add(null);
                }
            }
            return Boolean.TRUE;

        }
        return Boolean.FALSE;
    }

    @Override public void printAll() {

        for(int i=0; i< columnsList.get(0).size(); i++){
            for(List<String> col : columnsList){
                System.out.print(col.get(i));
                System.out.print(" | ");
            }
            System.out.println();
        }

    }

    @Override public void printFiltered(String column_name, String Value) {

    }

    @Override public boolean constraintCheck(Map<String, String> values) {



        return Boolean.TRUE;
    }
}
