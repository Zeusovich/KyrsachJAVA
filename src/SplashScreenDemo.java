import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SplashScreenDemo extends JFrame{


    public SplashScreenDemo() {
        setResizable(false);
        setSize(600, 500);
        setTitle("SplashScreen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width / 2 - 250, dimension.height / 2 - 250);

        // work with image
        JLabel label = new JLabel();
        add(label);
        label.setSize(800,600);

        try{
            BufferedImage image = ImageIO.read(new File("procent.jpg"));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(300,160,image.SCALE_SMOOTH));
            label.setIcon(icon);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        // Buttons
        JButton b1 = new JButton("Далее");
        JButton b2 = new JButton("Выход");
        add(b1);
        add(b2);
        b1.setBounds(5,420,285,30);
        b2.setBounds(295,420,285,30);
        b2.addActionListener(e -> {
            System.exit(0);});

        b1.addActionListener(e -> {
            Calculation calculation =  new Calculation();
            calculation.setVisible(true);
            dispose();
        });


        add(new MyComponent());
    }

    static class MyComponent extends JComponent {
        protected void paintComponent(Graphics g) {
            // шрифт
            Font font1 = new Font("TimesRoman", Font.BOLD, 14);
            Graphics2D g1 = (Graphics2D) g;
            g1.setFont(font1);
            g1.drawString(" Белорусский национальный технический университет", 60, 30);
            g1.drawString(" Выполнил: студент гр.10702318", 320, 250);
            g1.drawString(" Ермаков Даниил Сергеевич", 320, 270);
            g1.drawString(" Проверил: к.ф.-м.н.,доц.", 320, 320);
            g1.drawString(" Сидорик Валерий Владимирович", 320, 340);

            Font font2 = new Font("TimesRoman", Font.BOLD, 12);
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(font2);
            g2.drawString(" Факультет информационных технологий и робототехники", 130, 60);
            g2.drawString(" Кафедра программного обеспечения информационных систем и технологий", 70, 80);

            g2.drawString(" Минск, 2021", 250, 400);

            Font font3 = new Font("TimesRoman", Font.BOLD, 25);
            Graphics2D g3 = (Graphics2D) g;
            g3.setFont(font3);
            g3.drawString(" Курсовая работа", 190, 140);
            g3.drawString(" Расчет процентов по кредиту", 110, 200);


            Font font4 = new Font("TimesRoman", Font.BOLD, 16);
            Graphics2D g4 = (Graphics2D) g;
            g4.setFont(font4);
            g4.drawString(" По дисциплине 'Программирование на Java' ", 120, 165);
        }

    }


}
