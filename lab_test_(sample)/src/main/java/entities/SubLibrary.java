import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
  final class SubLibrary implements EntitiesClass
{
   @Id
   private Integer id;
   private String subject;
   @OneToMany
   private Author[] author;
}
