package quiz.example.psychologytests.activityTest.stateadapter;

public class StateIntelect {

    private String name; // название
    private String name1; // название

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    private int flagResource; // ресурс флага

    public StateIntelect(String name, String name1){

        this.name=name;

        this.name1=name1;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getFlagResource() {
        return this.flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }
}