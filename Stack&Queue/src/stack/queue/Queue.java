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
public class Queue<T> {
    public class Node<T>{
        T data;
        Node<T> next;
        Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    Node<T> front = null;
    
    public void enQueue(T data){
        Node newNode = new Node(data);
        if(front == null) front = newNode;
        else{
            Node temp = front;
            while(temp.next != null){
                temp = temp.next; 
            }
            temp.next = newNode;
        }
    }
    
    public T deQueue(){
        T data ;
        if(front == null){
            //System.out.println("Stack is empty");
            return null;
        }
        else{
            data = front.data;
            front = front.next;
        }
        return data;
    }
    
    public void display(){
        if(front == null) System.out.println("Queue is empty");
        else{
            Node temp = front;
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
       if(front == null) return null;
        else return front.data;
    }
    
    public int length(){
        int count = 0;
        if(front == null) return count;//System.out.println("Stack is empty");
        else{
            Node temp = front;
            count++;
            while(temp.next != null){
                temp = temp.next;
                count++;
            }
        }
        return count;
    }
}
