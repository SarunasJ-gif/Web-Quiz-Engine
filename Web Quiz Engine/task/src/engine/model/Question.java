package engine.model;

import io.micrometer.core.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name="questions")
public class Question {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    private String title;
    @NotEmpty
    private String text;

    @NonNull
    @Size(min=2)
    private String[] options;

    @NonNull
    private int[] answer;


    public Question() {
        options = new String[0];
        answer = new int[0];
    }


    public Question(String title, String text, String[] options, int[] answer) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.answer = (answer == null ? new int[]{} : answer);
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
        Question question = (Question) o;
        return answer == question.answer && Objects.equals(title, question.title) && Objects.equals(text, question.text) && Arrays.equals(options, question.options);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(title, text, Arrays.hashCode(answer));
        result = 31 * result + Arrays.hashCode(options);
        return result;
    }

}
