package engine.controller;

import engine.model.Answer;
import engine.model.Success;
import engine.model.Question;
import engine.model.QuestionDTO;
import engine.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.util.Arrays;
import java.util.Optional;

@RestController
//@Validated
public class QuizController {

    QuizService service = new QuizService();

//    Question q = new Question("The Java Logo",
//            "What is depicted on the Java logo?",
//            new String[]{"Robot", "Tea leaf", "Cup of coffee", "Bug"},
//            2);
//
//
//    @GetMapping("/api/quiz")
//    public Question getQuestion() {
//        return question;
//    }
//
    @PostMapping("/api/quizzes/{id}/solve")
    public Success getAnswer(@PathVariable int id, @RequestBody @Valid Answer answer) {
        Optional <QuestionDTO> optionalQuestion = Optional.ofNullable(service.getQuestionById(id));
        if (optionalQuestion.isEmpty()) {
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            QuestionDTO question = optionalQuestion.get();
            if (Arrays.equals(answer.getAnswer(), question.getAnswer())) {
                return new Success(true, "Congratulations, you're right!");
            } else {
                return new Success(false, "Wrong answer! Please, try again.");
            }
        }
    }

    @PostMapping("/api/quizzes")
    public ResponseEntity<?> addQuestion(@RequestBody @Valid Question question) {
        QuestionDTO questionDTO = service.addQuestion(question);
        return new ResponseEntity<>(questionDTO, HttpStatus.OK);
    }

    @GetMapping("/api/quizzes/{id}")
    public ResponseEntity<?> getQuestion(@PathVariable int id) {
        Optional <QuestionDTO> optionalQuestion = Optional.ofNullable(service.getQuestionById(id));
        if (optionalQuestion.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            QuestionDTO question = optionalQuestion.get();
            return new ResponseEntity<>(question, HttpStatus.OK);
        }
    }

    @GetMapping("/api/quizzes")
    public Iterable<QuestionDTO> getAllQuestions() {
        return service.getAllQuestions();
    }

}
