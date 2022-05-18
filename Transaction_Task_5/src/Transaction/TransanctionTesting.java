/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Transaction;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Munish kumar
 */
public class TransanctionTesting {
    static final OpenTransanction OT = new OpenTransanction();
    static final Scanner SC = new Scanner(System.in);
    enum Functionalities{
        SET,
        GET,
        UNSET,
        COUNT,
        BEGIN,
        ROLLBACK,
        COMMIT,
        UPDATE,
        END
    }
    static String key = "";
    static int value = 0;
    
    public static void main(String[] args) {
        System.out.println("Use END command to terminate the process");
        boolean check = true;
        while(check){
            try{
                String inputCommand = SC.next();
                Functionalities command = Functionalities.valueOf(inputCommand);
                switch(command){
                    case SET -> {
                        key = SC.next();
                        value = SC.nextInt();
                        OT.set(key, value);
                    }
                    case GET -> {
                        key = SC.next();
                        if(OT.get(key) == -1) System.out.println("null");
                        else System.out.println(OT.get(key));
                    }
                    case UNSET -> {
                        key = SC.next();
                        if(!OT.unset(key)) System.out.println("No variable named : " + key);
                        //else System.out.println();
                    }
                    case UPDATE -> {
                        key = SC.next();
                        value = SC.nextInt();
                        if(!OT.update(key, value)) System.out.println("No variable named : " + key);
                        //else System.out.println();
                    }
                    case COUNT -> {
                        value = SC.nextInt();
                        if(OT.count(value) == 0) System.out.println("null");
                        else System.out.println(OT.count(value));
                    }
                    case COMMIT -> {
                        OT.commit();
                    }
                    case BEGIN -> {
                        OT.begin();
                    }
                    case ROLLBACK -> {
                        OT.rollback();
                    }
                    case END -> {
                        check = false;
                    }
                }
            }catch(IllegalArgumentException I){
                System.out.println("Wrong command");     
            }catch(InputMismatchException e){
                System.out.println(e);
            }
        }
    }
}
