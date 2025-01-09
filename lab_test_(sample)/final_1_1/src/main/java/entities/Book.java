import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.Date;
import jakarta.persistence.ManyToOne;

@Entity
  final class Book implements EntitiesClass
{
   @Id
   private Integer id;
   private String name;
   private Date dateOfCreation;
   @ManyToOne
   private Author author;
}
