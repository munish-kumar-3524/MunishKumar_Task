/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaction;

import datastructure.HashMap;

/**
 *
 * @author Munish kumar
 */
public class Transanction {
    HashMap<String, Integer> variables = new HashMap<>();
    
    public void set(String key, Integer value){
        if(variables.isAvailable(key)) {
            this.variables.set(key, value);
        }
        else {
            this.variables.put(key, value);
        }
    }
    
//    public int receive(String key){
//        if(this.variables.get(key) != null){
//            return this.variables.get(key);
//        }else return -1;
//    }
    
    public boolean update(String key, Integer value){
        return this.variables.set(key, value);
    }
    
    public boolean unset(String key){
        return this.variables.remove(key);
    }
    
}
