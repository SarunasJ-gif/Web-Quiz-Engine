package engine.repository;

import engine.model.CompletedQuiz;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompletedQuizRepository extends CrudRepository<CompletedQuiz, Integer> {

    Page<CompletedQuiz> findByUserName(String userName, Pageable pageable);
}
