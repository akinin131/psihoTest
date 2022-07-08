package quiz.example.psychologytests;

public class ObservationQw {
    private int Answer;
    private int numberQw;
     int oneText_10[] = new int[]{
             R.string.observationAnwer1_10,
             R.string.observationAnwer2_10,
             R.string.observationAnwer3_10,
             R.string.observationAnwer4_10,
             R.string.observationAnwer5_10,
             R.string.observationAnwer6_10,
             R.string.observationAnwer7_10,
             R.string.observationAnwer8_10,
             R.string.observationAnwer9_10,
             R.string.observationAnwer10_10,
             R.string.observationAnwer11_10,
             R.string.observationAnwer12_10,
             R.string.observationAnwer13_10,
             R.string.observationAnwer14_10,
             R.string.observationAnwer15_10

    };
    int oneText_5[] = new int[]{
            R.string.observationAnwer1_5,
            R.string.observationAnwer2_5,
            R.string.observationAnwer3_5,
            R.string.observationAnwer4_5,
            R.string.observationAnwer5_5,
            R.string.observationAnwer6_5,
            R.string.observationAnwer7_5,
            R.string.observationAnwer8_5,
            R.string.observationAnwer9_5,
            R.string.observationAnwer10_5,
            R.string.observationAnwer11_5,
            R.string.observationAnwer12_5,
            R.string.observationAnwer13_5,
            R.string.observationAnwer14_5,
            R.string.observationAnwer15_5

    };

    int oneText_3[] = new int[]{
            R.string.observationAnwer1_3,
            R.string.observationAnwer2_3,
            R.string.observationAnwer3_3,
            R.string.observationAnwer4_3,
            R.string.observationAnwer5_3,
            R.string.observationAnwer6_3,
            R.string.observationAnwer7_3,
            R.string.observationAnwer8_3,
            R.string.observationAnwer9_3,
            R.string.observationAnwer10_3,
            R.string.observationAnwer11_3,
            R.string.observationAnwer12_3,
            R.string.observationAnwer13_3,
            R.string.observationAnwer14_3,
            R.string.observationAnwer15_3

    };
    int observationQw[] = new int[]{
            R.string.observationqw1,
            R.string.observationqw2,
            R.string.observationqw3,
            R.string.observationqw4,
            R.string.observationqw5,
            R.string.observationqw6,
            R.string.observationqw7,
            R.string.observationqw8,
            R.string.observationqw9,
            R.string.observationqw10,
            R.string.observationqw11,
            R.string.observationqw12,
            R.string.observationqw13,
            R.string.observationqw14,
            R.string.observationqw15,


    };


    public ObservationQw() {
    }

    public ObservationQw(int answer, int numberQw) {
        Answer = answer;
        this.numberQw = numberQw;
    }

    public int isAnswer() {
        return Answer;
    }

    public void setAnswer(int answer) {
        Answer = answer;
    }

    public int getNumberQw() {
        return numberQw;
    }

    public void setNumberQw(int numberQw) {
        this.numberQw = numberQw;
    }
}
