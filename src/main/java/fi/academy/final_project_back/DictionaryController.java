package fi.academy.final_project_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DictionaryController {

    @Autowired
    DictionaryRepository dictRepo;

    @GetMapping("/dictionary")
    public Iterable<Dictionary> getAllDictionaryEntries() {
        return dictRepo.findAll();
    }

    @GetMapping("dictionary/{id}")
    public ResponseEntity<?> getOneDictionaryEntry(@PathVariable(value = "id") Integer id) {
        Optional<Dictionary> d = dictRepo.findById(id);
        if (d.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(d.get());
    }

    @PostMapping("/dictionary")
    public ResponseEntity<?> addDictionaryEntry(@RequestBody Dictionary dictionaryEntry) {
        dictRepo.save(dictionaryEntry);
        return ResponseEntity.ok("Added");
    }

    @DeleteMapping("/dictionary/{id}")
    public ResponseEntity<?> removeDictionaryEntry(@PathVariable(value = "id") Integer id) {
        Optional<Dictionary> d = dictRepo.findById(id);
        if (d.isPresent()) {
            dictRepo.deleteById(id);
            return ResponseEntity.ok("Deleted");
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/dictionary/{id}")
    public ResponseEntity<Dictionary> updateDictionaryEntry(@PathVariable(value = "id") Integer id, @RequestBody Dictionary dictionaryEntry) {
        Optional<Dictionary> d = dictRepo.findById(id);
        if (d.isPresent()) {
            Dictionary toUpdate = d.get();
            toUpdate.setFinnish(dictionaryEntry.getFinnish());
            toUpdate.setEnglish(dictionaryEntry.getEnglish());
            toUpdate.setFinnish_def(dictionaryEntry.getFinnish_def());
            toUpdate.setEnglish_def(dictionaryEntry.getEnglish_def());
            dictRepo.save(toUpdate);
            return ResponseEntity.ok(toUpdate);
        }
        return ResponseEntity.notFound().build();
    }
}
