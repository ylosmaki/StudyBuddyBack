package fi.academy.final_project_back;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
@CrossOrigin(origins = "*")
public class NotesController {

    @Autowired
    NotesRepository noRep;

    //all notes from every week
    @GetMapping("")
    public Iterable<Notes> allNotes() {
        Iterable<Notes> allNotes = noRep.findAll();
        return allNotes;
    }

    //notes for a specific week
    @GetMapping("/{week}")
    public List<Notes> oneNote(@PathVariable(value="week") Integer week) {
        List<Notes> oneNote = noRep.findAllByWeek(week);
        return oneNote;
    }

    //new note
    @PostMapping("")
    public ResponseEntity<?> addNote(@RequestBody Notes note) {
        noRep.save(note);
        return ResponseEntity.ok("Added");
    }

    //find note by id and delete if exists
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer id) {
        Optional<Notes> note = noRep.findById(id);
        if (note.isPresent()) {
            noRep.deleteById(id);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.notFound().build();
    }

    //identifies note by id and updates it
    @PutMapping("/{id}")
    public ResponseEntity<Notes> updateNote(@PathVariable(value = "id") Integer id, @RequestBody Notes note) {
        Optional<Notes> old = noRep.findById(id);
        if (old.isPresent()) {
            Notes brandNew = old.get();
            brandNew.setText(note.getText());
            brandNew.setWeek(note.getWeek());
            noRep.save(brandNew);
            return ResponseEntity.ok(brandNew);
        }
        return ResponseEntity.notFound().build();
    }
}