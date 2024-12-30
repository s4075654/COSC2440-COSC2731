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
  final class AuthorController
{
   @Autowired
     private AuthorService service;
   
   @PostMapping("/authors")
     final ResponseEntity<Author[]> add(@RequestBody final Author[] AUTHORS)
       {
	  return ResponseEntity.status(HttpStatus.CREATED)
	    .body(service.add(AUTHORS));
       }
   @PutMapping("/authors")
     final ResponseEntity<Author[]> update(@RequestBody final Author[] AUTHORS)
       {
	  return ResponseEntity.ok(service.update(AUTHORS));
       }
   @DeleteMapping("/authors")
     final ResponseEntity<Void> delete(@RequestBody final Author[] AUTHORS)
       {
	  service.delete(AUTHORS);
	  return ResponseEntity.noContent().build();
       }
   @GetMapping("/authors")
     final Author[] search(@RequestParam final NameOrAcademicCredentials BY, @RequestParam final String NAME_OR_ACADEMIC_CREDENTIALS, @RequestParam final Order ORDER)
       {
	  return service.search(BY, NAME_OR_ACADEMIC_CREDENTIALS, ORDER);
       }
}
