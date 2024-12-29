package controllers;

import org.springframework.context.annotation.RestController;

@RestController
  final class LibraryController
{
   final void add(final SubLibrary[] SUB);
   final void update(final SubLibrary[] SUB);
   final void searchBySubject(final String SUBJECT);
   final void order(final Order ORDER);
}
