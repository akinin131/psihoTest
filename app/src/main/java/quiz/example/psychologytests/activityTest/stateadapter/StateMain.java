package quiz.example.psychologytests.activityTest.stateadapter;

public class StateMain {

    private String name; // название
    private String name1; // название


    public StateMain(String name,String name1){
        this.name=name;
        this.name1=name1;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }
}