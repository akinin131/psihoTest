package quiz.example.psychologytests.activityTest.stateadapter;

public class StateEntrepreneur {

    private String name; // название
    private String name1; // название

    private int flagResource; // ресурс флага

    public StateEntrepreneur(String name,  String name1){

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