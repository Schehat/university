/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTable;


import java.util.List;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

@Named(value = "studentsListBean")
@RequestScoped
public class StudentsListBean  {

    private StudentManager studentManager = StudentManager.singleton();

    
    public List<Student> getStudList() {
        return studentManager.getAllStudents();
    }

    public String saveStudent(StudentsShowBean sbean) {
        //konvertiere Bean in normales Objekt, denn der Manager kennt keine Beans:
        Student s = new Student(sbean.getVorname(), sbean.getName(), sbean.getNr());
        studentManager.saveStudent(s);
        return "dataTableWithButton";
    }

}
