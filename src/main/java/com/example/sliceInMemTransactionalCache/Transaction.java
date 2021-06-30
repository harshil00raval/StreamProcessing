package com.example.sliceInMemTransactionalCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transaction {

    private final Map<String, String> transStorage;
    private final List<Operation> ops = new ArrayList<>();
    private final Storage stg = Storage.getStorage();

    private final List<Operation> executionList = new ArrayList<>();

    public Transaction(){
        transStorage = new HashMap<>();
    }

    public void addOperation(Operation op){
        executionList.add(op);
    }

    //only read operation , no impct on transaction, not ading in OpsList
    public String get(String key){
        String value = stg.get(key);
        transStorage.put(key, value);
        return value;
    }

    public void set(String key, String value){
        transStorage.put(key, value);

    }

    public void remove(String key){
        if(transStorage.containsKey(key))
            transStorage.remove(key);
    }

    //only read operation , no impct on transaction, not ading in OpsList
    public int count(String value){
        return 0;
    }

    public void execute(Operation op){
        if("get".equals(op.getOperation())){
            get(op.getKey());
        }else if("set".equals(op.getOperation())){
            set(op.getKey(), op.getValue());
            ops.add(op);
        }else if("remove".equals(op.getOperation())){
            remove(op.getKey());
            ops.add(op);
        }else if("count".equals(op.getOperation())){
            count(op.getValue());
        }else if("commit".equals(op.getOperation())){
            commit();
        }else if("rollback".equals(op.getOperation())){
            rollback();
        }
    }

    public void rollback(){
        ops.clear();
    }

    public void commit(){
        stg.commit(ops);
    }

    public void executeAll(){
        executionList.forEach(op -> execute(op));
    }

}
