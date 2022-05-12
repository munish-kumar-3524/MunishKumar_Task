/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.queue;

/**
 *
 * @author Munish kumar
 * @param <T>
 */
public class Stack<T> {
    public class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    Node<T> top = null;
    
    public void push(T data){
        Node newNode = new Node(data);
        if(top == null) top = newNode;
        else{
            newNode.next =  top;
            top = newNode;
        }
    }
    
    public T pop(){
        T data ;
        if(top == null){
            //System.out.println("Stack is empty");
            return null;
        }
        else{
            data = top.data;
            top = top.next;
        }
        return data;
    }
    
    public void display(){
        if(top == null) System.out.println("Stack is empty");
        else{
            Node temp = top;
            System.out.println(temp.data);
            while(temp.next != null){
                temp = temp.next;
                System.out.println(temp.data);
            }
        }
    }
    
    public T peek(){
//        if(top == null){
//            //System.out.println("Stack is empty");
//        }
        if(top == null) return null;
        else return top.data;
        
    }
    
    public int length(){
        int count = 0;
        if(top == null) return count;//System.out.println("Stack is empty");
        else{
            Node temp = top;
            count++;
            while(temp.next != null){
                temp = temp.next;
                count++;
            }
        }
        return count;
    }
}
