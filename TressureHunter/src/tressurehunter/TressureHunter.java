/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tressurehunter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author Munish kumar
 */
public class TressureHunter {
    private int adventurerRow, adventurerColumn;
    private int goldRow, goldColumn;
    private int monsterRow, monsterColumn;
    private int trigerRow, trigerColumn;
    private static List<List<Character>> dungenGrid = new ArrayList<>();
        
    public List<List<Character>> getDungenGrid() {
        return dungenGrid;
    }

    public void setDungenGrid(List<List<Character>> dungenGrid) {
        this.dungenGrid = dungenGrid;
    }
    
    public void displayGrid(){
        for(int i = 0; i < dungenGrid.size(); i++){
            var dungenColumn = dungenGrid.get(i);
            for(int j = 0; j < dungenColumn.size(); j++){
                System.out.print(dungenColumn.get(j));
            }
            System.out.println();
        }
    }
    
    public boolean checkOutOFBound(int targetRow, int targetColumn){
        if(targetRow-1 < 0 && targetRow-1 > dungenGrid.size()) return false;
        if(targetColumn-1 < 0 && targetColumn-1 > dungenGrid.get(0).size()) return false;
        return true;
    }
    
    public boolean checkColision(int targetRow, int targetColumn){
        if(!dungenGrid.get(targetRow-1).get(targetColumn-1).equals('.')) return false;
        return true;
    }
    
    public void setAdventurer(int adventurerRow, int adventurerColumn){
        this.adventurerRow = adventurerRow;
        this.adventurerColumn = adventurerColumn;
        var dungenColumn = dungenGrid.get(adventurerRow-1);
        dungenColumn.set(adventurerColumn-1, 'A');
    }
    
    public void setMonster(int monsterRow, int monsterColumn){
        this.monsterRow = monsterRow;
        this.monsterColumn = monsterColumn;
        var dungenColumn = dungenGrid.get(monsterRow-1);
        dungenColumn.set(monsterColumn-1, 'M');
    }
    
    public void setGold(int goldRow, int goldColumn){
        this.goldRow = goldRow;
        this.goldColumn = goldColumn;
        var dungenColumn = dungenGrid.get(goldRow-1);
        dungenColumn.set(goldColumn-1, 'G');
    }
    
    public void setTriger(int trigerRow, int trigerColumn){
        this.trigerRow = trigerRow;
        this.trigerColumn = trigerColumn;
        var dungenColumn = dungenGrid.get(trigerRow-1);
        dungenColumn.set(trigerColumn-1, 'T');
    }
    
    public void setPit(int pitRow, int pitColumn){
        var dungenColumn = dungenGrid.get(pitRow-1);
        dungenColumn.set(pitColumn-1, 'P');
    }
    
    private static List<List<Character>> getDuplicateDungen(){
        List<List<Character>> tempGrid = new ArrayList<>();
        for(int i = 0; i < dungenGrid.size(); i++){
            var dungenColumn = dungenGrid.get(i);
            List<Character> tempColumn = new ArrayList<>();
            for(int j = 0; j < dungenColumn.size(); j++){
                tempColumn.add(dungenColumn.get(j));
            }
            tempGrid.add(tempColumn);
        }
        return tempGrid;
    }
    
    public int printDistance(){ // return minimum distance from adventurer to gold or return -1
	int DistanceFromAdventurerToGold = computeDistanceForAdventurer(adventurerRow-1, adventurerColumn-1, goldRow-1, goldColumn-1);
	int DistanceFromMonsterToGold = computeDistanceForMonster(monsterRow-1, monsterColumn-1, goldRow-1, goldColumn-1) + 1; // Monster starts moving after Adventurer starts mooving so monster is 1 step behind
	if(DistanceFromAdventurerToGold >= DistanceFromMonsterToGold){
		int DistanceFromAdventurerToTriger = computeDistanceForAdventurer(adventurerRow-1, adventurerColumn-1, trigerRow-1, trigerColumn-1);
		int DistanceFromMonsterToTriger = computeDistanceForMonster(monsterRow-1, monsterColumn-1, trigerRow-1, trigerColumn-1) + 1;
		if(DistanceFromAdventurerToTriger < DistanceFromMonsterToTriger){
			return DistanceFromAdventurerToTriger + computeDistanceForAdventurer(trigerRow-1, trigerColumn-1, goldRow-1, goldColumn-1);
		}else return -1;
	}
	return DistanceFromAdventurerToGold;
    }
    
    private static int computeDistanceForMonster(int sourceRow, int sourceColumn, int targetRow, int targetColumn){
        //breath first search
        List<List<Character>> tempDungenGrid = getDuplicateDungen();
        Node source = new Node(sourceRow, sourceColumn, 0);
        Queue<Node> Queue = new LinkedList<>();
        Queue.add(source);
        while(!Queue.isEmpty()){
            Node tempNode = Queue.poll();
            if(tempDungenGrid.get(tempNode.getRow()).get(tempNode.getColumn()).equals(dungenGrid.get(targetRow).get(targetColumn))){
                return tempNode.getDistanceFromTheSource();
            }else{
                tempDungenGrid.get(tempNode.getRow()).set(tempNode.getColumn(), '*');// Using (*) to indicate visited position

                if((tempNode.getRow()-1 >= 0 && tempNode.getRow()-1 < tempDungenGrid.get(0).size()) && !tempDungenGrid.get(tempNode.getRow()-1).get(tempNode.getColumn()).equals('*')) {
                        Node node = new Node(tempNode.getRow()-1, tempNode.getColumn(), tempNode.getDistanceFromTheSource()+1);
                        Queue.add(node);
                }
                if((tempNode.getRow()+1 >= 0 && tempNode.getRow()+1 < tempDungenGrid.get(0).size()) && !tempDungenGrid.get(tempNode.getRow()+1).get(tempNode.getColumn()).equals('*')) {
                        Node node = new Node(tempNode.getRow()+1, tempNode.getColumn(), tempNode.getDistanceFromTheSource()+1);
                        Queue.add(node);
                }
                if((tempNode.getColumn()-1 >= 0 && tempNode.getColumn()-1 < tempDungenGrid.size()) && !tempDungenGrid.get(tempNode.getRow()).get(tempNode.getColumn()-1).equals('*')) {
                        Node node = new Node(tempNode.getRow(), tempNode.getColumn()-1, tempNode.getDistanceFromTheSource()+1);
                        Queue.add(node);
                }

                if((tempNode.getColumn()+1 >= 0 && tempNode.getColumn()+1 < tempDungenGrid.size()) && !tempDungenGrid.get(tempNode.getRow()).get(tempNode.getColumn()+1).equals('*')) {
                        Node node = new Node(tempNode.getRow(), tempNode.getColumn()+1, tempNode.getDistanceFromTheSource()+1);
                        Queue.add(node);
                }
            }
        }
        return -1;
    }
    
    private static int computeDistanceForAdventurer(int sourceRow, int sourceColumn, int targetRow, int targetColumn){   
        //bfs
        List<List<Character>> tempDungenGrid = getDuplicateDungen();
        Node source = new Node(sourceRow, sourceColumn, 0);
        Queue<Node> Queue = new LinkedList<>();
        Queue.add(source);
        while(!Queue.isEmpty()){
            Node tempNode = Queue.poll();
            if(tempDungenGrid.get(tempNode.getRow()).get(tempNode.getColumn()).equals(dungenGrid.get(targetRow).get(targetColumn))){
                return tempNode.getDistanceFromTheSource();
            }else{
                tempDungenGrid.get(tempNode.getRow()).set(tempNode.getColumn(), 'P');// Using (pit) to indicate visited position

                if((tempNode.getRow()-1 >= 0 && tempNode.getRow()-1 < tempDungenGrid.get(0).size()) && !tempDungenGrid.get(tempNode.getRow()-1).get(tempNode.getColumn()).equals('P')) {
                        Node node = new Node(tempNode.getRow()-1, tempNode.getColumn(), tempNode.getDistanceFromTheSource()+1);
                        Queue.add(node);
                }
                if((tempNode.getRow()+1 >= 0 && tempNode.getRow()+1 < tempDungenGrid.get(0).size()) && !tempDungenGrid.get(tempNode.getRow()+1).get(tempNode.getColumn()).equals('P')) {
                        Node node = new Node(tempNode.getRow()+1, tempNode.getColumn(), tempNode.getDistanceFromTheSource()+1);
                        Queue.add(node);
                }
                if((tempNode.getColumn()-1 >= 0 && tempNode.getColumn()-1 < tempDungenGrid.size()) && !tempDungenGrid.get(tempNode.getRow()).get(tempNode.getColumn()-1).equals('P')) {
                        Node node = new Node(tempNode.getRow(), tempNode.getColumn()-1, tempNode.getDistanceFromTheSource()+1);
                        Queue.add(node);
                }

                if((tempNode.getColumn()+1 >= 0 && tempNode.getColumn()+1 < tempDungenGrid.size()) && !tempDungenGrid.get(tempNode.getRow()).get(tempNode.getColumn()+1).equals('P')) {
                        Node node = new Node(tempNode.getRow(), tempNode.getColumn()+1, tempNode.getDistanceFromTheSource()+1);
                        Queue.add(node);
                }
            }
        }
        return -1;
    }
}
