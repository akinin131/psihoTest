package quiz.example.psychologytests.qw;

public class KindnessQw {
    private boolean Answer;
    private int numberQw;

    public KindnessQw() {
    }

    public KindnessQw(boolean answer, int numberQw) {
        Answer = answer;
        this.numberQw = numberQw;
    }

    public boolean isAnswer() {
        return Answer;
    }

    public void setAnswer(boolean answer) {
        Answer = answer;
    }

    public int getNumberQw() {
        return numberQw;
    }

    public void setNumberQw(int numberQw) {
        this.numberQw = numberQw;
    }
}
