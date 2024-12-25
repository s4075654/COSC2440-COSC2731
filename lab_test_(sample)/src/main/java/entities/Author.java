package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
final class Author implements EntitiesClass
{
   @Id
   final private Integer ID;
   final private String NAME;
   final private String ACADEMIC_CREDENTIALS;
   final private Book[] BOOKS;
}
