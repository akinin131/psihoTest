package quiz.example.psychologytests.qw;

import quiz.example.psychologytests.R;

public class IntelectOneAnswer {

    private boolean Answer;
    private int numberQw;

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

    public IntelectOneAnswer(boolean answer, int numberQw) {
        Answer = answer;
        this.numberQw = numberQw;
    }

    public IntelectOneAnswer() {
    }

    public int[] IntelectQW = new int[]{
            R.string.IntelectOne_qw_1,
            R.string.IntelectOne_qw_2,
            R.string.IntelectOne_qw_3,
            R.string.IntelectOne_qw_4,
            R.string.IntelectOne_qw_5,
            R.string.IntelectOne_qw_6,
            R.string.IntelectOne_qw_7,
            R.string.IntelectOne_qw_8,
            R.string.IntelectOne_qw_9,
            R.string.IntelectOne_qw_10,
            R.string.IntelectOne_qw_11,
            R.string.IntelectOne_qw_12,
    };
}