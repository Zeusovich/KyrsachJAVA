import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <strong>класс AboutAuthor унаследован от JFrame</strong>
 *
 * <i>класс для создания окна "Об авторе"</i>
 *
 * @author Ермаков Даниил
 * @version 1.0
 */
class AboutAuthor extends JFrame {
    /**
     * <i> Конструктор для создания обьекта</i>
     */
    public AboutAuthor(){
        setResizable(false);
        setTitle("Об авторе");
        setSize(400, 500);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        setLocation(dimension.width / 2 - 250, dimension.height / 2 - 250);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JButton button = new JButton("Назад");
        button.setBounds(125,420,150,30);
        add(button);

        button.addActionListener(e -> {
            dispose();
        });

        JLabel label = new JLabel();
        add(label);
        label.setSize(400,300);

        try{
            BufferedImage image = ImageIO.read(new File("Barca.jpg"));
            ImageIcon icon = new ImageIcon(image.getScaledInstance(365,300,image.SCALE_SMOOTH));
            label.setIcon(icon);
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        label.setBounds(10,30,365,300);


        add(new AboutAuthor.MyComponent());
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
            Font font1 = new Font("TimesRoman", Font.BOLD, 16);
            Graphics2D g1 = (Graphics2D) g;
            g1.setFont(font1);
            g1.drawString(" Автор", 180, 320);
            g1.drawString(" Студент гр.10702318", 110, 350);
            g1.drawString(" Ермаков Даниил Сергеевич", 80, 380);
            g1.drawString(" danikermakov1706@gmail.com", 75, 410);
        }
    }
}
