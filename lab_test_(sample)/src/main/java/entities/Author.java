package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
final class Author implements EntitiesClass
{
   @Id
   final private Integer ID;
   final private String NAME;
   final private String ACADEMIC_CREDENTIALS;
   @OneToMany(mappedBy = "AUTHOR")
   final private Book[] BOOKS;
}
