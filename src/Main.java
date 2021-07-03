import sun.security.krb5.internal.Ticket;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static JLabel winnerLabel = new JLabel();

    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setTitle("Tic Tac Toe");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(800,600);

        JPanel host = new JPanel();
        LayoutManager containerGrid = new BoxLayout(host,BoxLayout.Y_AXIS);
        Box boxes[] = new Box[2];
        boxes[0] = Box.createHorizontalBox();
        boxes[1] = Box.createHorizontalBox();

        boxes[0].createGlue();
        boxes[1].createGlue();

        host.add(boxes[0]);
        host.add(boxes[1]);


        boxes[0].add(winnerLabel);
        TicTacToe gampanel = new TicTacToe(window);
        gampanel.setPreferredSize(window.getSize());
        boxes[1].add(gampanel);
        window.add(host);

        window.setVisible(true);

    }

}
