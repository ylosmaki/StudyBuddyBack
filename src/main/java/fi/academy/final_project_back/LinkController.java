package fi.academy.final_project_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class LinkController {
    @Autowired
    private LinkRepository linkrepo;

    @GetMapping ("/links")
    private Iterable<Link> getAllLinks(){
        return linkrepo.findAll();
    }

    @GetMapping("/links/{week}")
    public List<Link> getLinkWithId(@PathVariable(name="week", required = true) Integer week) {
        return linkrepo.findAllByWeek(week);
    }

    @PostMapping("/links")
    public ResponseEntity<?> addLink(@RequestBody Link link) {
        linkrepo.save(link);
        return ResponseEntity.ok("Added");
    }
    @DeleteMapping("/links/{id}")
    public ResponseEntity<?> removeLink(@PathVariable(value = "id") Integer id) {
        Optional<Link> l = linkrepo.findById(id);
        if (l.isPresent()) {
            linkrepo.deleteById(id);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/links/{id}")
    public ResponseEntity<?> updateDiaryEntry(@PathVariable(value = "id") Integer id, @RequestBody Link link) {
        Optional<Link> l = linkrepo.findById(id);
        if (l.isPresent()) {
            Link toUpdate = l.get();
            toUpdate.setLink(link.getLink());
            toUpdate.setTitle(link.getTitle());
            toUpdate.setDescription(link.getDescription());
            toUpdate.setWeek(link.getWeek());
            linkrepo.save(toUpdate);
            return ResponseEntity.ok(toUpdate);
        }
        return ResponseEntity.notFound().build();
    }
}
