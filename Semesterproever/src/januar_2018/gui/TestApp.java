package januar_2018.gui;

import januar_2018.controller.Controller;
import januar_2018.model.Hold;

public class TestApp {
    public static void main(String[] args) {
        Controller.initStorage();
        for (Hold h : Controller.holdUdenTutorer()) {
            System.out.println(h);
        }
        System.out.println();

        for (String s : Controller.getUddannelser().get(0).tutorOversigt()) {
            System.out.println(s);
        }

        System.out.println();

        Controller.tutorOversigtTilFil("C:\\Users\\Mads S-J\\Desktop\\projects\\PRO1\\Semesterproever\\src\\januar_2018\\controller\\tutorOversigtTilFil.txt");
    }
}
