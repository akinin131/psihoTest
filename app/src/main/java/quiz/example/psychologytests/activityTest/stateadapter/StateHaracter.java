package quiz.example.psychologytests.activityTest.stateadapter;

public class StateHaracter {

    private String name; // название

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    private String name1; // название



    public StateHaracter(String name,String name1){

        this.name=name;
        this.name1=name1;

    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}