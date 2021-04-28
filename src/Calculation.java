import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Calculation extends JFrame {

    public Calculation() {
        setResizable(false);
        Procent p = new Procent();
        setTitle("Расчет процентов по кредиту");
        setSize(500, 500);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width / 2 - 250, dimension.height / 2 - 250);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //mainPanel.setLayout(new GridBagLayout());

        Dimension labelSize = new Dimension(80, 80);

        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);

        //JPanel mainPanel = new JPanel();
       // mainPanel.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        GridLayout layout = new GridLayout(3, 2, 5, 30);
        mainPanel.setLayout(layout);
        //mainPanel.setLayout(new BorderLayout());


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


        /*
        GroupBox через Panel
         */

        Font font = new Font("Verdana", Font.PLAIN , 11);
        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

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

        //JButton button1 = new JButton("О программе");
        //JButton button2 = new JButton("Об авторе");
        JButton button3 = new JButton("Рассчитать");
        JButton button4 = new JButton("Выход");
        add(button3);
        //add(button1);
        //add(button2);
        add(button4);
        button3.setBounds(100,300,300,30);
        //button1.setBounds(15,370,140,60);
        //button2.setBounds(160,370,140,60);
        button4.setBounds(380,370,100,60);

        /*button2.addActionListener(e -> {
            AboutAuthor aboutAuthor = new AboutAuthor();
            aboutAuthor.setVisible(true);});*/

        /*button1.addActionListener(e -> {

            AboutProgram aboutProgram = new AboutProgram();
            aboutProgram.setVisible(true);});*/




        button4.addActionListener(e -> {
                    System.exit(0);
                });
            //AboutProgram ab = new AboutProgram();

            //ab.setVisible(false);

        button3.addActionListener(e -> {
            double i = Double.parseDouble (text1.getText());
            double a  = Double.parseDouble (text2.getText());
            double b  = Double.parseDouble (text3.getText());
            p.setSum(i);
            p.setSum(a);
            p.setSum(b);

            p.setProcent(i,a,b);
            p.getstr1();
            p.getstr2();
            p.getstr3();
            text4.setText(p.getstr1());
            text5.setText(p.getstr2());
            text6.setText(p.getstr3());


            /*String str1 = Double.toString(monpay1);
            String str2 = Double.toString(creditsum1);
            String str3 = Double.toString(overpay1);*/


        });

        add(new MyComponent1());
        menuBar.add(fileMenu);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setVisible(true);
        getContentPane().add(mainPanel);
    }
        static class MyComponent1 extends JComponent {
        }


}
