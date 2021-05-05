import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

/**
 * <strong> класс Calculation унаследован от JFrame</strong>
 *
 * <i> инициализирует основное окно программы</i>
 *
 * @author Ермаков Даниил
 * @version 1.0
 */
public class Calculation extends JFrame {

    /**
     * <i>конструктор для создания обьекта</i>
     */
    public Calculation() {
        setResizable(false);
        Procent p = new Procent();
        setTitle("Расчет процентов по кредиту");
        setSize(500, 500);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width / 2 - 250, dimension.height / 2 - 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        GridLayout layout = new GridLayout(3, 2, 5, 30);
        mainPanel.setLayout(layout);

        JPanel sourcedataPanel = new JPanel(new GridLayout());
        sourcedataPanel.setBorder(
                BorderFactory.createTitledBorder("Исходные данные"));

        GridLayout layout1 = new GridLayout(3, 0, 5, 5);

        Font font5 = new Font("Verdana", Font.PLAIN, 12);

        JLabel label1 = new JLabel("Сумма кредита в банке");
        label1.setLayout(new GridLayout());
        label1.setFont(font5);
        sourcedataPanel.add(label1);
        JTextField text1 = new JTextField();
        sourcedataPanel.add(text1);
        JLabel label2 = new JLabel("Годовая процентная ставка банка");
        label2.setFont(font5);
        sourcedataPanel.add(label2);
        JTextField text2 = new JTextField();
        sourcedataPanel.add(text2);
        JLabel label3 = new JLabel("Количество месяцев кредита");
        label3.setFont(font5);
        JTextField text3 = new JTextField();
        sourcedataPanel.add(label3);
        sourcedataPanel.add(text3);

        sourcedataPanel.setLayout(layout1);

        mainPanel.add(sourcedataPanel);

        JPanel finallydataPanel = new JPanel(new GridLayout());
        finallydataPanel.setBorder(
                BorderFactory.createTitledBorder("Расчет процентов по кредиту(аннуитетный платеж)"));

        GridLayout layout2 = new GridLayout(3, 0, 5, 5);

        JLabel label4 = new JLabel("Ежемесячный платеж");
        label4.setLayout(new GridLayout());
        label4.setFont(font5);
        finallydataPanel.add(label4);
        JTextField text4 = new JTextField();
        finallydataPanel.add(text4);
        JLabel label5 = new JLabel("Общая сумма по кредиту");
        label5.setFont(font5);
        finallydataPanel.add(label5);
        JTextField text5 = new JTextField();
        finallydataPanel.add(text5);
        JLabel label6 = new JLabel("Сумма переплат по кредиту");
        label6.setFont(font5);
        finallydataPanel.setLayout(layout2);
        finallydataPanel.add(label6);
        JTextField text6 = new JTextField();
        finallydataPanel.add(text6);

        mainPanel.add(finallydataPanel);

        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        Font font = new Font("Verdana", Font.PLAIN , 11);
        Menu fileMenu = new Menu("Файл");
        Menu helpMenu = new Menu("Помощь");
        MenuItem save = new MenuItem("Сохранить");
        MenuItem aboutProgramMenu = new MenuItem("О программе");
        MenuItem aboutAuthorMenu = new MenuItem("Об авторе");
        fileMenu.add(save);
        helpMenu.add(aboutProgramMenu);
        helpMenu.add(aboutAuthorMenu);

        save.addActionListener(e -> {
            try(FileWriter writer = new FileWriter("D:\\универ\\Kyrsach Java\\file.txt", false))
            {
                // запись всей строки
                String[] text = p.getStrings();
                for(int i = 0; i< text.length; i++)
                {
                    writer.write(text[i]);
                    writer.append("\n");
                }

                writer.flush();
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        });

        aboutProgramMenu.addActionListener(e -> {
            AboutProgram aboutProgram = new AboutProgram();
            aboutProgram.setVisible(true);});

        aboutAuthorMenu.addActionListener(e -> {
            AboutAuthor aboutAuthor = new AboutAuthor();
            aboutAuthor.setVisible(true);});

        JButton button3 = new JButton("Рассчитать");
        JButton button4 = new JButton("Выход");
        JButton button5 = new JButton("Очистить");
        add(button3);
        add(button4);
        add(button5);
        button3.setBounds(100,300,150,30);
        button4.setBounds(380,370,100,60);
        button5.setBounds(260,300,150,30);

        button5.addActionListener(e -> {
            text1.setText("");
            text2.setText("");
            text3.setText("");
            text4.setText("");
            text5.setText("");
            text6.setText("");
        });

        button4.addActionListener(e -> {
                    System.exit(0);
                });

        button3.addActionListener(e -> {
            double i = Double.parseDouble (text1.getText());
            double a  = Double.parseDouble (text2.getText());
            double b  = Double.parseDouble (text3.getText());

              p.setProcent(i,a,b);
              text4.setText(p.getStrings()[0]);;
              text5.setText(p.getStrings()[1]);
              text6.setText(p.getStrings()[2]);
        });

        add(new MyComponent1());
        menuBar.add(fileMenu);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setVisible(true);
        getContentPane().add(mainPanel);
    }

    /**
     *  <strong>Класс MyComponent1 наследован от JComponent</strong>
     *
     *  <i>для работы с визуальными компонентами</i>
     */
        static class MyComponent1 extends JComponent {
        }


}
