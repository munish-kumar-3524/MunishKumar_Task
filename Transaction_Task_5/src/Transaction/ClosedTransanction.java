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
public class ClosedTransanction extends Transanction{
    private static final CommitedTransanction COT = new CommitedTransanction();
    
    public int count(int value){
        return COT.variables.getCount(value);
    }
    
    public void commit(){
        LinkedList<String> list;
        list = this.variables.getKeys();
        for(int i=0; i<list.length(); i++){
            COT.variables.put(list.get(i), this.variables.get(list.get(i)));
        }
    }
}
