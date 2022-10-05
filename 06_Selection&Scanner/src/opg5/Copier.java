package opg5;

public class Copier {
    private int paper;
    private boolean jam;

    public Copier() {
        jam = false;
    }

    public Copier(int paper) {
        this.paper = paper;
        jam = false;
    }

    public void insertPaper(int paper) {
        if(this.paper + paper <= 500) {
            this.paper += paper;
        }
        else {
            System.out.println("Maximum capacity is 500 paper sheets. Current capacity is " + this.paper + ".");
            System.out.println("Therefore you can not insert " + paper + " sheets of paper.");
        }
    }

    public int getPaper() {
        return paper;
    }

    public void makeCopy() {
        if(jam) {
            System.out.println("The printer is jammed. Plz fix.");
        }
        else {
            if(paper > 0) {
                paper--;
            }
            else {
                System.out.println("Please insert more paper.");
            }

        }
    }

    public void makeCopy(int copies) {
        if(jam) {
            System.out.println("The printer is jammed. Plz fix.");
        }
        else {
            if (copies <= paper) {
                paper -= copies;
            }
            else {
                System.out.println("There is not sufficient paper to make " + copies + " copies.");
                System.out.println("Please insert more paper.");
            }

        }
    }

    public void makePaperJam() {
       jam = true;
    }

    public void fixPaperJam() {
        jam = false;
    }
}
