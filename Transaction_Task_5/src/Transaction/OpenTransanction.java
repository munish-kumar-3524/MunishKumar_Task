/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaction;

import datastructure.LinkedList;

/**
 *
 * @author Munish kumar
 */
public class OpenTransanction extends Transanction {
    
    private static final ClosedTransanction CT = new ClosedTransanction();
    
    public int get(String key){
        if(this.variables.isAvailable(key)) return this.variables.get(key);
        else if(CT.variables.isAvailable(key)) return CT.variables.get(key);
        else return -1;
    }
    
    public int count(int value){
        return this.variables.getCount(value) + CT.count(value);
    }
    
    public void begin(){
        LinkedList<String> list;
        list = this.variables.getKeys();
        for(int i=0; i<list.length(); i++){
            CT.variables.put(list.get(i), this.variables.get(list.get(i)));
        }
        this.variables.clear();//clear open transanction
    }
    
    public void commit(){
        CT.commit();
    }
    
    public void rollback(){
        this.variables.clear();
    }
}
