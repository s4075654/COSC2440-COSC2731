package controllers;

import org.springframework.context.annotation.RestController;

@RestController
final class AuthorController
{
   private static enum class NameOrAcademicCredentials
     {
	NAME, ACADEMIC_CREDENTIALS
     }
   
   final void add(final Author[] AUTHORS);
   final void update(final Author[] AUTHORS);
   final void delete(final Author[] AUTHORS);
   final void search(final NameOrAcademicCredentials BY, final String NAME_OR_ACADEMIC_CREDENTIALS);
   final void order(final Order ORDER);
}
