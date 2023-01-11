package quiz.example.psychologytests.qw;

import quiz.example.psychologytests.R;

public class IntelectRandomQw {
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

    public IntelectRandomQw(boolean answer, int numberQw) {
        Answer = answer;
        this.numberQw = numberQw;
    }

    public IntelectRandomQw() {
    }

    public int[] IntelectQW = new int[]{
            R.string.IntelectRandomQw_qw_1,
            R.string.IntelectRandomQw_qw_2,
            R.string.IntelectRandomQw_qw_3,
            R.string.IntelectRandomQw_qw_4,
            R.string.IntelectRandomQw_qw_5,
            R.string.IntelectRandomQw_qw_6,
            R.string.IntelectRandomQw_qw_7,
            R.string.IntelectRandomQw_qw_8,
            R.string.IntelectRandomQw_qw_9,
            R.string.IntelectRandomQw_qw_10,
            R.string.IntelectRandomQw_qw_11,
            R.string.IntelectRandomQw_qw_12,
    };
}
