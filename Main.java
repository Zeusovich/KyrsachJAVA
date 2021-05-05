import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JFrame;

/**
 * класс Main
 * @author Ермаков Даниил
 * @version 1.0
 */
public class Main {
    /**
     * функция main для создания обьекта jfrm класса SplashScreenDemo
     * @param args аргументы командной строки
     */
    public static void main(String[] args) {
        SplashScreenDemo jfrm = new SplashScreenDemo();
        jfrm.setVisible(true);
    }


}
