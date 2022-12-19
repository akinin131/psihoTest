package quiz.example.psychologytests.activityTest.stateadapter;

public class StateMain {

    private int name; // название
    private int name1; // название


    public StateMain(int name, int name1){
        this.name= name;
        this.name1=name1;
    }

    public int getName() {
        return this.name;
    }

    public void setName(int name) {
        this.name = name;
    }


    public int getName1() {
        return name1;
    }

    public void setName1(int name1) {
        this.name1 = name1;
    }
}