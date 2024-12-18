
package controller;

import api.StudentAPI;
import data.Student;
import service.StudentService;

import java.util.List;

public class StudentController implements StudentAPI {
    private final StudentService service = new StudentService();

    @Override
    public void addStudent(String id, String name, int age) {
       System.out.println(service.addStudent(id, name, age));
    }

    @Override
    public void getStudentDetails(String id) {
       System.out.println(service.getStudentDetails(id));
    }

    @Override
    public void updateStudent(String id, String name, int age) {
       System.out.println(service.updateStudent(id, name, age));
    }

    @Override
    public void removeStudent(String id) {
       System.out.println(service.removeStudent(id));
    }

    @Override
    public void getAllStudents() {
       System.out.println(service.getAllStudents());
    }
}
