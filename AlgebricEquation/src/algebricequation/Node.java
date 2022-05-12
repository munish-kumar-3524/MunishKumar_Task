/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algebricequation;

import java.util.TreeMap;

/**
 *
 * @author Munish kumar
 */
public class Node {
    int value = 1;
    char operator;
    TreeMap<String,Integer> map = new TreeMap<>(); // x^2y and yx^2 both are same but system cant understand if i use tree then xyz will get sorted so i dont have the issue of comparing x^2y and yx^2
//    
//    public void setValue(int value){
//        this.value = value;
//    }
//    
//    public void setOperator(char operator){
//        this.operator = operator;
//    }
//    
    public void setMap(String key, int value){
        map. put(key, value);
    }
}
