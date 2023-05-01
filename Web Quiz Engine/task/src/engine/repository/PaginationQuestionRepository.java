package engine.repository;

import engine.model.PaginationQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaginationQuestionRepository extends CrudRepository<PaginationQuestion, Integer> {

    Page<PaginationQuestion> findAll(Pageable pageable);
}
