package fi.academy.final_project_back;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotesRepository extends CrudRepository<Notes, Integer> {

    List<Notes> findAllByWeek(Integer week);
}
