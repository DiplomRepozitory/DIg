package Components;

import com.MyHandler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelWidthMenuItem extends JPanel {

    private ArrayList<JButton> menuItemsArrayList = new ArrayList<>();

    public ArrayList<JButton> getMenuItemsArrayList() {
        return menuItemsArrayList;
    }

    public PanelWidthMenuItem(ArrayList<String> namesItemMenu) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        for (String name : namesItemMenu) {
            JButton menuItems = new JButton();
            menuItems.setMinimumSize(new Dimension(300, 50));
            menuItems.setPreferredSize(new Dimension(300, 50));
            menuItems.setMaximumSize(new Dimension(300, 50));
            menuItems.setFont(new Font("Calibre", Font.BOLD, 12));
            menuItems.setAlignmentX(CENTER_ALIGNMENT);
            menuItems.setText(name);
            add(Box.createVerticalStrut(10));
            add(menuItems);
            menuItemsArrayList.add(menuItems);

            menuItems.addActionListener(e -> {
                switch (menuItems.getText()) {
                    case "Работа":
                        MyHandler.setStepReload(1);
                        break;
                    case "Обучение":
                        MyHandler.setStepReload(2);
                        break;
                    case "Тестирование":
                        MyHandler.setStepReload(3);
                        break;
                    case "Учебники":
                        MyHandler.setStepReload(4);
                        break;
                }
                MyHandler.getInstance().selectForms();
            });
        }

    }

}
