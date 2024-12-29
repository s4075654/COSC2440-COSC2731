package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
final class SubLibrary implements EntitiesClass
{
   @Id
   final private Integer ID;
   final private String SUBJECT;
   @OneToMany
   final private Author[] AUTHOR;
}
