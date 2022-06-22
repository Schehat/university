/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataTable;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author dunkel
 */
public class StudentManager {
    
    private static StudentManager exemplar = null;
    public static StudentManager singleton() {
        if (exemplar == null) {
            exemplar = new StudentManager();
        }
        return exemplar;
    }
    

    public StudentManager() {
        studList = new ArrayList<>();
        studList.add(new Student("Daisy", "Duck", 17111234));
        studList.add(new Student("Donald", "Duck", 42148007));
        studList.add(new Student("Uncle", "Dagobert", 12185561));
        studList.add(new Student("Goofy", "Disney", 32141114));
    }
    
    private List<Student> studList;
    
    public List<Student> getAllStudents(){
        return this.studList;
    }
    
    public void saveStudent(Student s) {
        Student studInList = this.getStudent(s.getNr());
        if (studInList == null) {             // neue Matrikelnummer
            studList.add(s);
        } else {
            studInList.setFirstName(s.getFirstName());
            studInList.setLastName(s.getLastName());
        }
    }

    public Student getStudent(int nr) {
        for (Student s : this.studList) {
            if (s.getNr() == nr) {
                return s;
            }
        }
        return null;
    }
    
}
