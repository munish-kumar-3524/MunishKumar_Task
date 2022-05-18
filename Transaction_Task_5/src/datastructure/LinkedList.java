/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datastructure;

/**
 *
 * @author Munish kumar
 * @param <T>
 */
public class LinkedList<T> {
    public class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    Node<T> head = null;
    
    public void add(T data){
        Node newNode = new Node(data);
        if(head == null) head = newNode;
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next; 
            }
            temp.next = newNode;
        }
    }
    
    public T get(int count){
        T data ;
        if(head == null){
            return null;
        }else if(count == 0) data = head.data;
        else{
            Node temp = head;
            int i = 1;
            while(temp.next != null && i != count){
                temp = temp.next;
                i++;
            }
            if(temp.next != null) data = (T)temp.next.data;
            else data = null;
        }
        return data;
    }
    
    public void display(){
        if(head == null) System.out.println("List is empty");
        else{
            Node temp = head;
            System.out.println(temp.data);
            while(temp.next != null){
                temp = temp.next;
                System.out.println(temp.data);
            }
        }
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
}
