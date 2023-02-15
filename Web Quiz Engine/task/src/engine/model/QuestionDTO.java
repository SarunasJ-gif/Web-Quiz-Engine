package engine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Arrays;
import java.util.Objects;

public class QuestionDTO {


    private int id;
    private String title;
    private String text;
    private String[] options;

    @JsonIgnore
    private int[] answer;

    @JsonIgnore
    private static int createID;



    public QuestionDTO(String title, String text, String[] options, int[] answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = answer == null ? new int[]{} : answer;
        this.id = createNewId();
    }

    public int createNewId() {
        return ++createID;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public int[] getAnswer() {
        Arrays.sort(answer);
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionDTO that = (QuestionDTO) o;
        return id == that.id && Objects.equals(title, that.title) && Objects.equals(text, that.text) && Arrays.equals(options, that.options) && Arrays.equals(answer, that.answer);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, title, text);
        result = 31 * result + Arrays.hashCode(options);
        result = 31 * result + Arrays.hashCode(answer);
        return result;
    }
}
