package engine.controller;

import engine.model.*;
import engine.repository.UserRepository;
import engine.service.QuizService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
//@Validated
public class QuizController {

    @Autowired
    private QuizService service;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(QuizController.class);

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

    @PostMapping("/api/register")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user) {
        List<User> users =  userRepository.findAll();
        for (User currentUser : users) {
            if (user.getEmail().equals(currentUser.getEmail())) {
                LOGGER.info(user.getEmail() + " " + user.getPassword() + " bad request");
                return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
            }
        }
        if (user.getEmail().contains(".") && user.getEmail().contains("@")) {
            LOGGER.info(users.toString(), " ok request");
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/api/quizzes/{id}")
    public ResponseEntity<?> deleteQuiz(@PathVariable int id) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = auth.getName();
        Optional<Question> optionalQuestion = service.getQuestionToDeleteById(id);
        if (optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            if (currentUserName.equals(question.getUserName())) {
                service.deleteQuiz(question);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/actuator/shutdown")
    public String shutDown() {
        return "Shut down";
    }

}
