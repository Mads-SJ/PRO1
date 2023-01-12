package januar_2022.controller;

public class App {
    public static void main(String[] args) {
        Controller.initStorage();
        String filePath = "C:\\Users\\Mads\\Desktop\\datamatiker\\1. semester\\PRO1\\PRO1\\Semesterproever\\src\\januar_2022\\controller\\test.txt";
        Controller.resultaterTilFil(Controller.getLøb().get(0), filePath);
    }
}
