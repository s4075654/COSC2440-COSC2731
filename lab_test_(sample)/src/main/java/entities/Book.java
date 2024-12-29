package entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import jakarta.persistence.ManyToOne;

@Entity
final class Book implements EntitiesClass
{
   @Id
   final private Integer ID;
   final private String NAME;
   final private Date DATE_OF_CREATION;
   @ManyToOne
   final private Author AUTHOR;
}
