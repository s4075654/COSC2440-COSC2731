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
  @RequestMapping("/sub-libraries")
  final class LibraryController
{
   @Autowired
     private LibraryService service;
   
   @PostMapping("/add")
     final ResponseEntity<SubLibrary[]> add(@RequestBody final SubLibrary[] SUB_LIBRARIES)
       {
	  return ResponseEntity.status(HttpStatus.CREATED)
	    .body(service.add(SUB_LIBRARIES));
       }
   @PutMapping("/update")
     final ResponseEntity<SubLibrary[]> update(@RequestBody final SubLibrary[] SUB_LIBRARIES)
       {
	  return ResponseEntity.ok(service.update(SUB_LIBRARIES));
       }
   @GetMapping("/search-by")
     final SubLibrary[] searchBy(@RequestParam final String SUBJECT, @RequestParam final Order ORDER)
       {
	  return service.searchBy(SUBJECT, ORDER);
       }
}
