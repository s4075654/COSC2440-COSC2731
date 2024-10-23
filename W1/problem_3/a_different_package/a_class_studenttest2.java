package a_different_package;

import the_same_package.Student;

final class StudentTest2
{
   public static void main(String[] args)
     {
	Student[] objects = new Student[2];
	objects[0] = new Student("student id", "full name", "major");
	objects[1] = new Student(objects[0].studentId.deleteCharAt(0).toString(), objects[0].fullName.deleteCharAt(0).toString(), objects[0].major.deleteCharAt(0).toString());
	System.out.println(objects[1].studentId + "\n" + objects[1].fullName + "\n" + objects[1].major);
     }
}