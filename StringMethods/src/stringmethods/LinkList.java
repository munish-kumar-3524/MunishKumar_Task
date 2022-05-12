/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stringmethods;

/**
 *
 * @author Munish kumar
 */
public class LinkList {
    public class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    
    public void insertData(int data){
        Node newNode = new Node(data);
        if(head == null) 
        {
            head = newNode;
        }
        else{
            Node temp = head;
            while(temp.next != null){
                temp = temp.next; 
            }
            temp.next = newNode;
        }
    }
    
    public int receiveData(int index){
        if(index == 0){
            return head.data;
        }else{
            Node temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            return temp.data;
        }
    }
    
    public void clear(){
        head = null;
    }
}
