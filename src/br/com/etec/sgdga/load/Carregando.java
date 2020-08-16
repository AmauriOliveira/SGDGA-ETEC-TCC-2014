package br.com.etec.sgdga.load;

import br.com.etec.sgdga.tela.InterfaceConfirmacao;
import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;

public class Carregando extends JWindow {

    InterfaceConfirmacao login;

    public Carregando() throws InterruptedException {

        ///conta para achar o centro da tela
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = (w - 640) / 2; // 500 e 258 é o tamanho da tela a ser carregada
        int y = (h - 400) / 2;
///definição da img de fundo
        JLabel img;
        img = new JLabel(new ImageIcon(getClass().getResource("/br/com/etec/sgdga/res/img/UNTITLED2.png")));
        img.setLocation(new Point(0, 0));
        img.setSize(540, 400);

///definição da img a ser carregada
        JLabel img2 = new JLabel(new ImageIcon(getClass().getResource("/br/com/etec/sgdga/res/img/df2.png")));
        img2.setLocation(new Point(20, 350));
        img2.setSize(0, 0);

/////definição da tela
        this.setLayout(null);
        this.setLocation(new Point(x, y));
        this.setSize(540, 400);
        setBackground(new Color(0, 0, 0, 0));
        //colocando as imgs na tela
        this.add(img2);
        this.add(img);
        //mostrando a tela
        this.setVisible(true);

        ////// fazer o load da img
        for (int i = 0; i < 101; i++) {
            Thread.sleep(100);
            img2.setSize(i * 5, 20);

        }
        try {

        } catch (AbstractMethodError e) {
            System.out.println("aviso");
        }
/// parada antes de fechar
        Thread.sleep(500);
///fechar

        if (login == null) {
            login = new InterfaceConfirmacao();
            login.setVisible(true);
        } else {
            login.setVisible(true);
            login.setState(JFrame.NORMAL);

        }
        this.setVisible(false);

    }

    @Override
    protected void finalize() throws Throwable {
        System.gc();
    }
//*/

    public static void main(String[] args) throws InterruptedException {

        Carregando carregandoSistema = new Carregando();

        try {
            carregandoSistema.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(Carregando.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
