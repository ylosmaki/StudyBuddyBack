package fi.academy.final_project_back;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface LinkRepository extends CrudRepository<Link, Integer> {

    @Query("SELECT link FROM Link link WHERE link.id = :id")
    Link getById(@Param("id") Integer id);
}
