package quiz.example.psychologytests.activityTest.stateadapter;

public class StateFamily {

    private String name; // название

    private int flagResource; // ресурс флага

    public StateFamily(String name, int flag){

        this.name=name;

        this.flagResource=flag;
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