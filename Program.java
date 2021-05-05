import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <strong>класс AboutProgram унаследован от JFrame</strong>
 *
 * <i>класс для создания окна "О программе"</i>
 *
 * @author Ермаков Даниил
 * @version 1.0
 */
class AboutProgram extends JFrame {
    /**
     * <i> Конструктор для создания обьекта</i>
     */
    public AboutProgram(){
        setResizable(false);
        setTitle("О программе");
        setSize(500, 300);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width / 2 - 250, dimension.height / 2 - 250);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JLabel label = new JLabel();
        add(label);
        label.setSize(200,250);

        try{
            BufferedImage image = ImageIO.read(new File("author.png"));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(150,150,image.SCALE_SMOOTH));
            label.setIcon(icon);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }


        add(new MyComponent());
        setVisible(true);
    }

    /**
     * <strong>класс MyComponent унаследован от JComponent</strong>
     *
     * <i>для работы с визуальными компонентами</i>
     */
    static class MyComponent extends JComponent {
        /**
         * <i>процедура создания различных шрифтов</i>
         *
         * @param g - обьект класса Graphics
         */
        protected void paintComponent(Graphics g) {
            // шрифт
            Font font1 = new Font("TimesRoman", Font.BOLD, 14);
            Graphics2D g1 = (Graphics2D) g;
            g1.setFont(font1);
            g1.drawString(" Расчет процентов по кредиту(аннуитетные платежи)", 60, 50);

            Font font2 = new Font("TimesRoman", Font.BOLD, 12);
            Graphics2D g2 = (Graphics2D) g;
            g2.setFont(font2);
            g2.drawString(" Программа позволяет:", 150, 90);
            g2.drawString(" 1.Рассчитать сумму аннуитетного платежа.", 150, 110);
            g2.drawString(" 2.Получить общую сумму выплат при аннуитетном ", 150, 130);
            g2.drawString(" способе погашения кредита. ", 150, 150);
            g2.drawString(" 3.Узнать сумму процентов(переплат) при аннуитетном  ", 150, 170);
            g2.drawString(" способе погашения кредита. ", 150, 190);

            Font font3 = new Font("TimesRoman", Font.BOLD, 12);
            Graphics2D g3 = (Graphics2D) g;
            g3.setFont(font3);
            g3.drawString(" Версия v. 1.0.0", 370, 250);
        }
    }
}
