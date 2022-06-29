/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tressurehunter;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Munish kumar
 */
public class TressureHunterTester {

    /**
     * @param args the command line arguments
     */
    private static final Scanner scanner = new Scanner(System.in);
    private static final TressureHunter tressureHunter = new TressureHunter();
    private static int rowInput, columnInput;
    
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            
            System.out.println("Enter the dimension of the dungen (Row and Column)");
            System.out.print("Enter the row : ");
            rowInput = scanner.nextInt();
            System.out.print("Enter the column : ");
            columnInput = scanner.nextInt();
            List<List<Character>> dungenGrid = new ArrayList<>();
            for(int i = 0; i < rowInput; i++){
                List<Character> dungenColumn = new ArrayList<>();
                for(int j = 0; j < columnInput; j++){
                    dungenColumn.add('.');
                }
                dungenGrid.add(dungenColumn);
            }
            tressureHunter.setDungenGrid(dungenGrid);
            
            boolean flag = true;
            while(flag){
                System.out.println("Enter the position of Adventurer (Row and column)");
                System.out.print("Enter the row : ");
                rowInput = scanner.nextInt();
                System.out.print("Enter the column : ");
                columnInput = scanner.nextInt();
                boolean check = tressureHunter.checkOutOFBound(rowInput, columnInput);
                if(check) flag = false;
                else{
                    System.out.println("Adventurer is out of dungen");
                    flag = true;
                    continue;
                }
                check = tressureHunter.checkColision(rowInput, columnInput);
                if(check) flag = false;
                else{
                    System.out.println("Position is already occupied");
                    flag = true;
                    continue;
                }
                tressureHunter.setAdventurer(rowInput, columnInput);
            }
            
            flag = true;
            while(flag){
                System.out.println("Enter the position of Monster (Row and column)");
                System.out.print("Enter the row : ");
                rowInput = scanner.nextInt();
                System.out.print("Enter the column : ");
                columnInput = scanner.nextInt();
                boolean check = tressureHunter.checkOutOFBound(rowInput, columnInput);
                if(check) flag = false;
                else{
                    System.out.println("Monster is out of dungen");
                    flag = true;
                    continue;
                }
                check = tressureHunter.checkColision(rowInput, columnInput);
                if(check) flag = false;
                else{
                    System.out.println("Position is already occupied");
                    flag = true;
                    continue;
                }
                tressureHunter.setMonster(rowInput, columnInput);
            }
            
            flag = true;
            while(flag){
                System.out.println("Enter the position of Gold (Row and column)");
                System.out.print("Enter the row : ");
                rowInput = scanner.nextInt();
                System.out.print("Enter the column : ");
                columnInput = scanner.nextInt();
                boolean check = tressureHunter.checkOutOFBound(rowInput, columnInput);
                if(check) flag = false;
                else{
                    System.out.println("Gold is out of dungen");
                    flag = true;
                    continue;
                }
                check = tressureHunter.checkColision(rowInput, columnInput);
                if(check) flag = false;
                else{
                    System.out.println("Position is already occupied");
                    flag = true;
                    continue;
                }
                tressureHunter.setGold(rowInput, columnInput);
            }
            
            flag = true;
            while(flag){
                System.out.println("Enter the position of Triger (Row and column)");
                System.out.print("Enter the row : ");
                rowInput = scanner.nextInt();
                System.out.print("Enter the column : ");
                columnInput = scanner.nextInt();
                boolean check = tressureHunter.checkOutOFBound(rowInput, columnInput);
                if(check) flag = false;
                else{
                    System.out.println("Triger is out of dungen");
                    flag = true;
                    continue;
                }
                check = tressureHunter.checkColision(rowInput, columnInput);
                if(check) flag = false;
                else{
                    System.out.println("Position is already occupied");
                    flag = true;
                    continue;
                }
                tressureHunter.setTriger(rowInput, columnInput);
            }
            
            System.out.print("Enter the number of pits : ");
            int numberOfPits = scanner.nextInt();
            int PitRows[] = new int[numberOfPits];
            int PitColumns[] = new int[numberOfPits];
            for(int i = 0; i < numberOfPits; i++){
                    flag = true;
                    while(flag){
                        System.out.println("Enter the position of pit " + i+1 + " (Row and Column) ");
                        System.out.print("Enter the row : ");
                        rowInput = scanner.nextInt();
                        System.out.print("Enter the column : ");
                        columnInput = scanner.nextInt();
                        boolean check = tressureHunter.checkOutOFBound(rowInput, columnInput);
                        if(check) flag = false;
                        else{
                            System.out.println("Triger is out of dungen");
                            flag = true;
                            continue;
                        }
                        check = tressureHunter.checkColision(rowInput, columnInput);
                        if(check) flag = false;
                        else{
                            System.out.println("Position is already occupied");
                            flag = true;
                            continue;
                        }
                    }
            PitRows[i] = rowInput;
            PitColumns[i] = columnInput;
            }
            for(int i = 0; i < numberOfPits; i++){
                    tressureHunter.setPit(PitRows[i], PitColumns[i]);
            }
            
            tressureHunter.displayGrid();
            System.out.println("Minimun posible distance from the source : ");
            int distance = tressureHunter.printDistance();
            if(distance == -1){
                System.out.println("Not possible solution");
            }else{
                System.out.println(distance);
            }
            
        }catch(InputMismatchException e){
            System.out.println(e);
        }
    }
    
}
