package entities;

import jakarta.persistence.Entity;
import jakarta.persisitence.Id;

@Entity
final class SubLibrary implements EntitiesClass
{
   @Id
   final private Integer ID;
   final private String SUBJECT;
   final private Author[] AUTHOR;
}
