package engine.service;

import engine.model.CompletedQuiz;
import engine.model.PaginationQuestion;
import engine.model.Question;
import engine.model.QuestionDTO;
import engine.repository.CompletedQuizRepository;
import engine.repository.PaginationQuestionRepository;
import engine.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {


    @Autowired
    private  QuestionRepository questionRepository;
    @Autowired
    private PaginationQuestionRepository paginationQuestionRepository;

    @Autowired
    CompletedQuizRepository completedQuizRepository;


    public QuestionDTO addQuestion(Question question) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        question.setUserName(userName);
        questionRepository.save(question);
        paginationQuestionRepository.save(new PaginationQuestion(question.getTitle(),
                question.getText(), question.getOptions(), userName));
        return new QuestionDTO(question.getId(),
                question.getTitle(),
                question.getText(), question.getOptions(),
                question.getAnswer());
    }

    public QuestionDTO getQuestionById(int id) {
        Optional<Question> optionalQuestion = questionRepository.findById(id);
            if (optionalQuestion.isEmpty()) {
                return null;
            } else {
                Question question = optionalQuestion.get();
                return new QuestionDTO(question.getId(),
                        question.getTitle(),
                        question.getText(), question.getOptions(),
                        question.getAnswer());
            }
    }

    public Page<PaginationQuestion> getAllQuestions(Integer page, Integer size) {
        return paginationQuestionRepository.findAll(PageRequest.of(page, size));
    }

    public Page<CompletedQuiz> getAllCompletedQuizzes(String userName, Integer page, Integer size) {
        return completedQuizRepository.findByUserName(userName, PageRequest.of(page, size,
                Sort.by("completedAt").descending()));
    }

    public Optional<Question> getQuestionToDeleteById(int id) {

        return questionRepository.findById(id);
    }

    public Optional<PaginationQuestion> getPaginationQuestionById(int id) {
        return paginationQuestionRepository.findById(id);
    }

    public void deleteQuiz(Question question) {
        questionRepository.delete(question);
    }

    public void deletePaginationQuestion(PaginationQuestion question) {
        paginationQuestionRepository.delete(question);
    }
}