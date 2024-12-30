import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
  @RequestMapping("/")
  final class BookController
{
   @Autowired
     final private BookService SERVICE;
   
   @PostMapping("/books")
     final ResponseEntity<Book[]> add(@RequestBody final Book[] BOOKS)
       {
	  return ResponseEntity.status(HttpStatus.CREATED)
	    .body(SERVICE.add(BOOKS));
       }
   @PutMapping("/books")
     final ResponseEntity<Book[]> update(@RequestBody final Book[] BOOKS)
       {
	  return ResponseEntity.ok(SERVICE.update(BOOKS));
       }
   @DeleteMapping("/books")
     final ResponseEntity<Void> delete(@RequestBody final Book[] BOOKS)
       {
	  SERVICE.delete(BOOKS);
	  return ResponseEntity.noContent().build();
       }
   @GetMapping("/books")
     final Book[] searchBy(@RequestParam final Object NAME_OR_THE_CREATED_DATE, @RequestParam final Order ORDER)
       {
	  return SERVICE.searchBy(NAME_OR_THE_CREATED_DATE, ORDER);
       }
}
