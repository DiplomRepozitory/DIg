package Form;

import Components.LabelForGreenText;
import Components.PanelForWork;
import com.MyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Work extends JFrame {

    private static Work work;
    private PanelForWork panelForWork;
    //окна для редактирования, там где текст.
    private LabelForGreenText label12,labelEmpty,label34,label56,label78;
    //Лист который хранит в себе индикаторы всех модемов в виде матрицы
    //                  \все первые индикаторы всех 8 модемов\
    //                  \все вторые индикаторы всех 8 модемов\
    //                  \  все ... индикаторы всех 8 модемов \
    //                  \все шестые индикаторы всех 8 модемов\
    private final JLabel [][] indicatorModemsMass = new JLabel[8][6];
    //кнопки и индикатор СОД на центральной панеле управления
    private JLabel labelRight, labelLeft, labelEnter, labelDel,labelSOD;
    //Все индикаторы и тумблер на панеле включения (самая правая)
    private JLabel labelIndicatorOnPanelVKL,labelIndicatorOnPanelDU,labelIndicatorOnPanel220,
            labelIndicatorOnPanel24V,labelVKL;
//    private JLabel label1A,label1103,label1104,label1105,label1106,label1109,
//            label2A,label2103,label2104,label2105,label2106,label2109,
//            label3A,label3103,label3104,label3105,label3106,label3109,
//            label4A,label4103,label4104,label4105,label4106,label4109,
//            label5A,label5103,label5104,label5105,label5106,label5109,
//            label6A,label6103,label6104,label6105,label6106,label6109,
//            label7A,label7103,label7104,label7105,label7106,label7109,
//            label8A,label8103,label8104,label8105,label8106,label8109;

    public static Work workInstance() {
        return work == null ? work = new Work() : work;
    }

    public Work() throws HeadlessException {

        super();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(new Dimension(Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height));
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        initional();
        setVisible(true);

    }

    private void initional() {
        panelForWork = new PanelForWork();
        getContentPane().add(panelForWork);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                MyHandler.setStepReload(0);
                MyHandler.getInstance().selectForms();
            }
        });

        initLabels();

    }

    private void initLabels(){
        label12=new LabelForGreenText(465,291);
        label12.setText("0Ч7А");
        label34=new LabelForGreenText(465,340);
        label34.setText("РЕД");
        label56=new LabelForGreenText(631,291);
        label56.setText("XX??");
        label78=new LabelForGreenText(631,340);
        label78.setText("ЧТЕН");
        labelEmpty=new LabelForGreenText(547,291);
        labelEmpty.setText("2Ф9В");

        panelForWork.add(label12);
        panelForWork.add(label34);
        panelForWork.add(label56);
        panelForWork.add(label78);
        panelForWork.add(labelEmpty);

        int massI=0,massJ=0;

        for (int i=254;i<355;i+=20){
            for (int j=90;j<1051;j+=85) {
                JLabel labelIndOnModem = new JLabel(new ImageIcon("Image/Индикатор сигнала на модем Красный.png"));
                labelIndOnModem.setBounds(j, i + 1, 20, 20);
                indicatorModemsMass[massI][massJ] = labelIndOnModem;
                panelForWork.add(labelIndOnModem);
                if (j==345){
                    j+=365;
                }
                massI++;
            }
            massI=0;
            massJ++;
        }

//        for (int i=0;i<indicatorModemsMass.length;i++){
//            System.out.println("Modem"+i);
//            for (int j=0;j<indicatorModemsMass[i].length;j++){
//                System.out.println(indicatorModemsMass[i][j]);
//            }
//        }

        labelRight = new JLabel(new ImageIcon("Image/Кнопка вправо.png"));
        labelRight.setBounds(580,330,32,32);

        labelLeft = new JLabel(new ImageIcon("Image/Кнопка влево.png"));
        labelLeft.setBounds(540,330,32,32);

        labelEnter = new JLabel(new ImageIcon("Image/ВВОД.png"));
        labelEnter.setBounds(540,370,32,32);

        labelDel = new JLabel(new ImageIcon("Image/СБРОС.png"));
        labelDel.setBounds(580,370,32,32);

        labelSOD = new JLabel(new ImageIcon("Image/Выключенный индикатор СОД.png"));
        labelSOD.setBounds(466,223,17,17);

        panelForWork.add(labelRight);
        panelForWork.add(labelLeft);
        panelForWork.add(labelEnter);
        panelForWork.add(labelDel);
        panelForWork.add(labelSOD);

        labelIndicatorOnPanelVKL = new JLabel(new ImageIcon("Image/Индикатор на панель включения.png"));
        labelIndicatorOnPanelVKL.setBounds(1205,245,20,20);

        labelIndicatorOnPanelDU = new JLabel(new ImageIcon("Image/Индикатор на панель включения.png"));
        labelIndicatorOnPanelDU.setBounds(1205,300,20,20);

        labelIndicatorOnPanel220 = new JLabel(new ImageIcon("Image/Индикатор на панель включения.png"));
        labelIndicatorOnPanel220.setBounds(1233,340,20,20);

        labelIndicatorOnPanel24V = new JLabel(new ImageIcon("Image/Индикатор на панель включения.png"));
        labelIndicatorOnPanel24V.setBounds(1233,385,20,20);

        labelVKL = new JLabel(new ImageIcon("Image/Тумблер Середина.png"));
        labelVKL.setBounds(1200,267,30,35);

        panelForWork.add(labelIndicatorOnPanelVKL);
        panelForWork.add(labelIndicatorOnPanelDU);
        panelForWork.add(labelIndicatorOnPanel220);
        panelForWork.add(labelIndicatorOnPanel24V);
        panelForWork.add(labelVKL);

    }
}