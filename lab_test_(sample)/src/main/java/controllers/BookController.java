package controllers;

import org.springframework.context.annotation.RestController;
import java.util.Date;

@RestController
  final class BookController
{
   final void add(final Book[] BOOKS);
   final void update(final Book[] BOOKS);
   final void delete(final Book[] BOOKS);
   final void searchBy(final String NAME);
   final void searchBy(final Date THE_CREATED_DATE);
   final void order(final Order ORDER);
}
