package engine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="completed_quiz")
public class CompletedQuiz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    @Column(name = "completed_id")
    private Integer completedId;

    private Integer id;
    @DateTimeFormat(style = "ISO")
    private LocalDateTime completedAt;

    @JsonIgnore
    private String userName;


    public CompletedQuiz() {}
    public CompletedQuiz(Integer id, LocalDateTime completedAt, String userName) {
        this.id = id;
        this.completedAt = completedAt;
        this.userName = userName;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(LocalDateTime completedAt) {
        this.completedAt = completedAt;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
