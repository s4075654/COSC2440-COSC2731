import problem3.Student;
import problem4.Lecturer;
import problem4.Project;
import problem_4.Researcher;

final class SchoolSystem
{
   private Student[] aListOfStudents = new Student[10];
   private Lecturer[] aListOfLecturers = new Lecturer[10];
   private Project[] aListOfProjects = new Project[10];
   
   private Byte numberOfElementsInStudentsList = 0, numberOfElementsInLecturersList = 0, numberOfElementsInProjectsList = 0;
   
   final public void supportAddingTheObjectsToTheStudentsList(final Student... ELEMENTS)
     {
	for (Student element: ELEMENTS)
	  {
	     switch (numberOfElementsInStudentsList)
	       {
		case final Byte NUMBER_OF_ELEMENTS_IN_STUDENTS_LIST when NUMBER_OF_ELEMENTS_IN_STUDENTS_LIST != 10:
		  aListOfStudents[numberOfElementsInStudentsList++] = element;
		default:
	       }
	  }
     }

   final public void supportAddingTheObjectsToTheLecturersList(final Lecturer... ELEMENTS)
     {
	for (Lecturer element: ELEMENTS)
	  {
	     switch (numberOfElementsInLecturersList)
	       {
		case final Byte NUMBER_OF_ELEMENTS_IN_LECTURERS_LIST when NUMBER_OF_ELEMENTS_IN_LECTURERS_LIST != 10:
		  aListOfLecturers[numberOfElementsInLecturersList++] = element;
		default:
	       }
	  }
     }
   
   final public void supportAddingTheObjectsToTheProjectsList(final Project... ELEMENTS)
     {
	for (Project element: ELEMENTS)
	  {
	     switch (numberOfElementsInProjectsList)
	       {
		case final Byte NUMBER_OF_ELEMENTS_IN_PROJECTS_LIST when NUMBER_OF_ELEMENTS_IN_PROJECTS_LIST != 10:
		  aListOfProjects[numberOfElementsInProjectsList++] = element;
		default:
	       }
	  }
     }
}