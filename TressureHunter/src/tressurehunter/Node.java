/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tressurehunter;

/**
 *
 * @author Munish kumar
 */
public class Node {
    private int row, column, distanceFromTheSource;

    public Node(int row, int column, int distanceFromTheSource) {
        this.row = row;
        this.column = column;
        this.distanceFromTheSource = distanceFromTheSource;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getDistanceFromTheSource() {
        return distanceFromTheSource;
    }
}
