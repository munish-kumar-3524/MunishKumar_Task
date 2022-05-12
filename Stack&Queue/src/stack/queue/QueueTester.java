/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack.queue;

import java.util.Scanner;

/**
 *
 * @author Munish kumar
 */
public class QueueTester {
    public static void main(    String[] args) {
        // TODO code application logic here
        Queue<Integer> q = new Queue<>();
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int data;
        while(check){
            System.out.print("Enter 1.enQueue 2.deQueue 3.display 4.peek 5.length : ");
            int n = sc.nextInt();
            switch(n){
                case 1 -> {
                    System.out.print("Enter data : ");
                    data = sc.nextInt();
                    q.enQueue(data);
                }
                case 2 -> {
                    System.out.println(q.deQueue());
                }
                case 3 -> q.display();
                case 4 -> {
                    if(q.peek() == null) System.out.println("The queue is empty");
                    else System.out.println(q.peek());
                }
                case 5 -> {
                    System.out.println(q.length());
                }

            }
            System.out.print("Do you want to continue 1-yes 0-no : ");
            n = sc.nextInt();
            if(n == 0) check = false;
        }
    }
}
