/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

/**
 *
 * @author Munish kumar
 * @param <Key>
 * @param <Value>
 */
public class HashMap<Key, Value> {
    public class Node<Key, Value>{
        Key key;
        Value data;
        Node<Key, Value> next;
        Node(Key key, Value data){
            this.data = data;
            this.key = key;
            this.next = null;
        }
    }
    Node<Key, Value> head = null;
    
    public void put(Key key, Value data){
        Node newNode = new Node(key, data);
        if(head == null) head = newNode;
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next; 
            }
            temp.next = newNode;
        }
    }
    
    public boolean set(Key key, Value data){
        if(head == null){
            return false;
        }
        else if(head.key.equals(key)) head.data = data;
        else {
            Node temp = head;
            while(temp.next != null){
                if(key.equals(temp.next.key)) break;
                temp = temp.next;
            }
            if(temp.next == null) return false;
            else if(temp.next.key.equals(key)) temp.next.data = data;
            else return false;
        }
        return true;
    }
    
    public Value get(Key key){
        Value data ;
        if(head == null){
            return null;
        }
        else if(head.key.equals(key)) data = (Value)head.data;
        else {
            Node temp = head;
            while(temp.next != null){
                if(temp.next.key.equals(key)) break;
                temp = temp.next;
            }
            if(temp.next == null){
                return null;
            }
            else if(temp.next.key.equals(key)) data = (Value)temp.next.data;
            else {
                return null;
            }
        }
        return data;
    }
    
    public boolean remove(Key key){
        if(head == null){
            return false;
        }
        else if(head.key.equals(key)){
            head = head.next;
            return true;
        }
        else {
            Node temp = head;
            while(temp.next != null){
                if(temp.next.key.equals(key)) break;
                temp = temp.next;
            }
            if(temp.next == null){
                if(temp.key.equals(key)){
                    temp = null;
                    return true;
                }
            }else if(temp.next.key.equals(key)){
                temp.next = temp.next.next;
                return true;
            }
        }
        return false;
    }
    
    public void display(){
        if(head == null) System.out.println("Map is empty");
        else{
            Node temp = head;
            System.out.println(temp.key + " " + temp.data);
            while(temp.next != null){
                temp = temp.next;
                System.out.println(temp.key + " " + temp.data);
            }
        }
    }
    
    public boolean isAvailable(Key key){
        boolean check = false;
        if(head == null) check = false;
        else if(head.key.equals(key)) check = true;
        else{
            Node temp = head;
            while(temp.next != null){
                if(temp.next.key.equals(key)) check = true;
                temp = temp.next;
            }
        }
        return check;
    }
    
    public LinkedList<Key> getKeys(){
        LinkedList<Key> list = new LinkedList<>();
        if(head == null) return list;
        else{
            list.add(head.key);
            Node temp = head;
            while(temp.next != null){
                list.add((Key)temp.next.key);
                temp = temp.next;
            }
        }
        return list;
    }
    
    public int length(){
        int count = 0;
        if(head == null) return count;
        else{
            Node temp = head;
            count++;
            while(temp.next != null){
                temp = temp.next;
                count++;
            }
        }
        return count;
    }
    
    public int getCount(Value data){
        int count = 0;
        if(head == null) return count;
        else{
            if(head.data == data) count++;
            Node temp = head;
            while(temp.next != null){
                if(temp.next.data == data) count++;
                temp = temp.next;
            }
        }
        return count;
    }
    
    public void clear(){
        head = null;
    }
}
