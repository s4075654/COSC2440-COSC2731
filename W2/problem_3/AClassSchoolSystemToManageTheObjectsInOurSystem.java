import problem3.Student;
import problem4.Lecturer;
import problem4.Project;

final class SchoolSystem
{
   private Student[] aListOfStudents = new Student[10];
   private Lecturer[] aListOfLecturers = new Lecturer[10];
   private Project[] aListOfProjects = new Project[10];
   
   private byte numberOfElementsInStudentsList = 0, numberOfElementsInLecturersList = 0, numberOfElementsInProjectsList = 0;
   
   final public void supportAddingTheObjectsToTheStudentsList(final Student... ELEMENTS)
     {
	for (Student element: ELEMENTS)
	  {
	     if (numberOfElementsInStudentsList != 10)
	       {
		  aListOfStudents[numberOfElementsInStudentsList++] = element;
	       }
	     else 
	       {
		  break;
	       }
	  }
     }

      final public void supportAddingTheObjectsToTheLecturersList(final Lecturer... ELEMENTS)
     {
	for (Lecturer element: ELEMENTS)
	  {
	     if (numberOfElementsInLecturersList != 10)
	       {
		  aListOfLecturers[numberOfElementsInLecturersList++] = element;
	       }
	     else 
	       {
		  break;
	       }
	  }
     }
   
      final public void supportAddingTheObjectsToTheProjectsList(final Project... ELEMENTS)
     {
	for (Project element: ELEMENTS)
	  {
	     if (numberOfElementsInProjectsList != 10)
	       {
		  aListOfProjects[numberOfElementsInProjectsList++] = element;
	       }
	     else 
	       {
		  break;
	       }
	  }
     }
}
