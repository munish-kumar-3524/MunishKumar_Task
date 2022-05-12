/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stack.queue;

import java.util.Scanner;

/**
 *
 * @author Munish kumar
 */
public class StackTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Stack<Integer> st = new Stack<>();
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        int data;
        while(check){
            System.out.print("Enter 1.push 2.pop 3.display 4.peek 5.length : ");
            int n = sc.nextInt();
            switch(n){
                case 1 -> {
                    System.out.print("Enter data : ");
                    data = sc.nextInt();
                    st.push(data);
                }
                case 2 -> System.out.println(st.pop());
                case 3 -> st.display();
                case 4 -> {
                    if(st.peek() == null) System.out.println("The stack is empty");
                    else System.out.println(st.peek());
                }
                case 5 -> {
                    System.out.println(st.length());
                }
            }
            System.out.print("Do you want to continue 1-yes 0-no : ");
            n = sc.nextInt();
            if(n == 0) check = false;
        }
    }
    
}
