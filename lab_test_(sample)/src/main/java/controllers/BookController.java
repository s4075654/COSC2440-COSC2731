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
  @RequestMapping("/books")
  final class BookController
{
   @Autowired
     private BookService service;
   
   @PostMapping("/add")
     final ResponseEntity<Book[]> add(@RequestBody final Book[] BOOKS)
       {
	  return ResponseEntity.status(HttpStatus.CREATED)
	    .body(service.add(BOOKS));
       }
   @PutMapping("/update")
     final ResponseEntity<Book[]> update(@RequestBody final Book[] BOOKS)
       {
	  return ResponseEntity.ok(service.update(BOOKS));
       }
   @DeleteMapping("/delete")
     final ResponseEntity<Void> delete(@RequestBody final Book[] BOOKS)
       {
	  service.delete(BOOKS);
	  return ResponseEntity.noContent().build();
       }
   @GetMapping("/search-by")
     final Book[] searchBy(@RequestParam final Object NAME_OR_THE_CREATED_DATE, @RequestParam final Order ORDER)
       {
	  return service.searchBy(NAME_OR_THE_CREATED_DATE, ORDER);
       }
}
