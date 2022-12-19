package quiz.example.psychologytests.activityTest.stateadapter;

public class StateHaracter {

    private int name; // название



    public int getName1() {
        return name1;
    }

    public void setName1(int name1) {
        this.name1 = name1;
    }

    private int name1; // название



    public StateHaracter(int name, int name1){

        this.name=name;
        this.name1=name1;

    }

    public int getName() {
        return this.name;
    }

    public void setName(int name) {
        this.name = name;
    }

}