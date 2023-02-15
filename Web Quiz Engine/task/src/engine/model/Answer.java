package engine.model;

import io.micrometer.core.lang.NonNull;

import java.util.Arrays;

public class Answer {

    @NonNull
    private int[] answer;

    public Answer() {}

    public int[] getAnswer() {
        Arrays.sort(answer);
        return answer;
    }

    public void setAnswer(int[] answer) {
        this.answer = answer;
    }
}
