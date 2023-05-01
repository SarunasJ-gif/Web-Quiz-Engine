package engine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.micrometer.core.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="pagination_question")
public class PaginationQuestion {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String title;
        private String text;
        private String[] options;

        @JsonIgnore
        private String userName;

    public PaginationQuestion() {}

    public PaginationQuestion(String title, String text, String[] options, String userName) {
        this.title = title;
        this.text = text;
        this.options = options;
        this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
