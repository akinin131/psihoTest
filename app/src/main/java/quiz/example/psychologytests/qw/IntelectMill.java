package quiz.example.psychologytests.qw;

import quiz.example.psychologytests.R;

public class IntelectMill {

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

    public IntelectMill(boolean answer, int numberQw) {
        Answer = answer;
        this.numberQw = numberQw;
    }

    public IntelectMill() {
    }

    public int[] IntelectQW = new int[]{
            R.string.IntelectMill_qw_1,
            R.string.IntelectMill_qw_2,
            R.string.IntelectMill_qw_3,
            R.string.IntelectMill_qw_4,
            R.string.IntelectMill_qw_5,
            R.string.IntelectMill_qw_6,
            R.string.IntelectMill_qw_7,
            R.string.IntelectMill_qw_8,
            R.string.IntelectMill_qw_9,
            R.string.IntelectMill_qw_10,
            R.string.IntelectMill_qw_11,
            R.string.IntelectMill_qw_12,
    };
}
