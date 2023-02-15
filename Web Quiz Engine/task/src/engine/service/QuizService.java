package engine.service;

import engine.model.Question;
import engine.model.QuestionDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuizService {

    private final List<QuestionDTO> questions;

    public QuizService() {
        this.questions = Collections.synchronizedList(new ArrayList<>());
    }

    public QuestionDTO addQuestion(Question question) {
        QuestionDTO questionDTO = new QuestionDTO(
                question.getTitle(),
                question.getText(), question.getOptions(),
                question.getAnswer());
        questions.add(questionDTO);
        return questionDTO;
    }

    public QuestionDTO getQuestionById(int id) {
        for (QuestionDTO question : questions) {
            if (id == question.getId()) {
                return question;
            }
        }
        return null;
    }

    public List<QuestionDTO> getAllQuestions() {
        return questions;
    }
}
