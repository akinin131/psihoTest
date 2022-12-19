package quiz.example.psychologytests.activityTest.stateadapter;

public class StateEntrepreneur {

    private int name; // название

    public int getName1() {
        return name1;
    }

    private int name1; // название

    private int flagResource; // ресурс флага

    public StateEntrepreneur(int name, int name1){

        this.name=name;

        this.name1=name1;
    }

    public int getName() {
        return this.name;
    }

    public void setName(int name) {
        this.name = name;
    }


    public int getFlagResource() {
        return this.flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }
}