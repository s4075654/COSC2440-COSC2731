package api;

import java.util.Map;

public interface StudentAPI
{
   void addStudent(String id, String name, int age);
   void getStudentDetails(String id);
   void updateStudent(String id, String name, int age);
   void removeStudent(String id);
   void getAllStudents();
}
