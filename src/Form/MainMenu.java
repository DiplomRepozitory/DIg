package Form;

import Components.PanelWidthMenuItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class MainMenu extends JFrame {

    private static MainMenu mainMenu;
    PanelWidthMenuItem panel;

    public static MainMenu menuInstance() {
        return mainMenu == null ? mainMenu = new MainMenu() : mainMenu;
    }

    public MainMenu() throws HeadlessException {
        super();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(500, 500));
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout());
        ArrayList<String> nameArrayList = new ArrayList<>();
        Collections.addAll(nameArrayList, ("Работа Обучение Тестирование Учебники").split(" "));
        panel = new PanelWidthMenuItem(nameArrayList);
        add(panel);
        setVisible(true);
    }
}
