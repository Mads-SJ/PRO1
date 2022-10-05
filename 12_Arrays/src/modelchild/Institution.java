package modelchild;

public class Institution {
    private String name;
    private String address;
    private Child[] children;
    private int noOfChildren;
    private static final int MAX_NUMBER_OF_CHILDREN = 10;

    public Institution(String name, String address) {
        this.name = name;
        this.address = address;
        children = new Child[MAX_NUMBER_OF_CHILDREN];
    }

    public void addChild(Child child) {
        if (noOfChildren < MAX_NUMBER_OF_CHILDREN) {
            children[noOfChildren] = child;
            noOfChildren++;
        }
    }

    public double averageAge() {
        int sum = 0;
        double averageAge = 0.0;

        for (int i = 0; i < noOfChildren; i++) {
            sum += children[i].getAge();
        }

        if (sum > 0) {
            averageAge = (double) sum / noOfChildren;
        }

        return averageAge;
    }

    public int numberOfGirls() {
        int noOfGirls = 0;

        for (int i = 0; i < noOfChildren; i++) {
            if (!children[i].isBoy()) {
                noOfGirls++;
            }
        }

        return noOfGirls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
