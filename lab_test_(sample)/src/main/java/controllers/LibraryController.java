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
  final class LibraryController
{
   @Autowired
     final private LibraryService SERVICE;
   
   @PostMapping("/sub-libraries")
     final ResponseEntity<SubLibrary[]> add(@RequestBody final SubLibrary[] SUB_LIBRARIES)
       {
	  return ResponseEntity.status(HttpStatus.CREATED)
	    .body(SERVICE.add(SUB_LIBRARIES));
       }
   @PutMapping("/sub-libraries")
     final ResponseEntity<SubLibrary[]> update(@RequestBody final SubLibrary[] SUB_LIBRARIES)
       {
	  return ResponseEntity.ok(SERVICE.update(SUB_LIBRARIES));
       }
   @GetMapping("/sub-libraries")
     final SubLibrary[] searchBy(@RequestParam final String SUBJECT, @RequestParam final Order ORDER)
       {
	  return SERVICE.searchBy(SUBJECT, ORDER);
       }
}
