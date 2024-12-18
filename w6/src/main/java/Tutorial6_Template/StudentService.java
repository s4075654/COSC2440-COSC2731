
package service;

import data.Student;
import data.StudentRepository;

import java.util.List;

public class StudentService {
    private final StudentRepository repository = new StudentRepository();

    public int addStudent(String id, String name, int age) {
       return repository.addStudent(new Student(id, name, age));
    }

    public Student getStudentDetails(String id) {
       return repository.getStudent(id);
    }

    public int updateStudent(String id, String name, int age) {
       return repository.updateStudent(id, new Student(id, name, age));
    }

    public int removeStudent(String id) {
       return repository.removeStudent(id);
    }

    public List<Student> getAllStudents() {
       return repository.getAllStudents();
    }
}
