package opg5;

public class CopierTester {
    public static void main(String[] args) {
        Copier copier = new Copier(1);
        copier.makeCopy();
        System.out.println("MAKE COPY EMPTY TEST");
        copier.makeCopy();
        System.out.println("");

        System.out.println("INSERT 501 PAPER MAX TEST");
        copier.insertPaper(501);
        System.out.println("");

        System.out.println("INSERT 500 PAPER TEST");
        copier.insertPaper(500);
        System.out.println("Number of paper sheets in printer: " + copier.getPaper());
        System.out.println("");

        System.out.println("MAKE 100 COPIES TEST");
        copier.makeCopy(100);
        System.out.println("Number of paper sheets in printer: " + copier.getPaper());
        System.out.println("");

        System.out.println("MAKE 401 COPIES EMPTY TEST");
        copier.makeCopy(401);
        System.out.println("");

        System.out.println("MAKE COPY WHILE JAMMED");
        copier.makePaperJam();
        copier.makeCopy();
        System.out.println("");


        System.out.println("MAKE 100 COPIES WHILE JAMMED");
        copier.makeCopy(100);
        System.out.println("");


        System.out.println("MAKE COPY WHILE NOT JAMMED");
        copier.fixPaperJam();
        System.out.println("Number of paper sheets before copying: " + copier.getPaper());
        copier.makeCopy();
        System.out.println("Number of paper sheets after copying: " + copier.getPaper());
        System.out.println("");
    }
}
