/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package railwayreservationsystem;

/**
 *
 * @author Munish kumar
 */
public class Passengers {
    private String name;
    private int age;
    private String gender;
    private String berthPreference;
    private Children children = null;

    public Passengers(String name, int age, String gender, String berthPreference) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.berthPreference = berthPreference;
    }

    public void setChildren(Children children) {
        this.children = children;
    }

    public void setBerthPreference(String berthPreference) {
        this.berthPreference = berthPreference;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getBerthPreference() {
        return berthPreference;
    }

    public Children getChildren() {
        return children;
    }
}
