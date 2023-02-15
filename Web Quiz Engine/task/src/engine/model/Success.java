package engine.model;

import java.util.Objects;

public class Success {

    private boolean success;
    private String feedback;

    public Success(boolean success, String feedback) {
        this.success = success;
        this.feedback = feedback;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Success answer = (Success) o;
        return success == answer.success && Objects.equals(feedback, answer.feedback);
    }

    @Override
    public int hashCode() {
        return Objects.hash(success, feedback);
    }
}
