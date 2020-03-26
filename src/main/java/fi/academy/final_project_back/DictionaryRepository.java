package fi.academy.final_project_back;

import org.springframework.data.repository.CrudRepository;


public interface DictionaryRepository extends CrudRepository<Dictionary, Integer> {

    Iterable<Dictionary> findByFinnishContainingIgnoreCase(String finnish);

    Iterable<Dictionary> findByEnglishContainingIgnoreCase(String english);

}
