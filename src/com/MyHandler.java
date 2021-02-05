package com;

import Form.MainMenu;
import Form.Work;

public class MyHandler {
    private static MyHandler processing;
    private static int stepReload = 0;
    private MainMenu mainMenu;

    private MyHandler() {
        selectForms();
        System.out.println(getClass().getResource("Image/Индикатор на панель включения.png"));
    }

    public static MyHandler getInstance() {
        return processing == null ? processing = new MyHandler() : processing;
    }

    public static void setStepReload(int stepReload) {
        MyHandler.stepReload = stepReload;
    }

    public void selectForms() {

        if (stepReload == 0) {
            mainMenu = MainMenu.menuInstance();
            mainMenu.setVisible(true);
            return;
        }
        if (stepReload == 1) {
            mainMenu.setVisible(false);
            Work.workInstance().setVisible(true);
        }
    }
}
