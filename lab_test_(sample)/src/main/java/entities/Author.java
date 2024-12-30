import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
  final class Author implements EntitiesClass
{
   @Id
   private Integer id;
   private String name;
   private String academicCredentials;
   @OneToMany(mappedBy = "AUTHOR")
   private Book[] books;
}
