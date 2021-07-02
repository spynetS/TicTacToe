import sun.security.krb5.internal.Ticket;

import javax.swing.*;

public class Main {


    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setTitle("Tic Tac Toe");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(800,600);
        TicTacToe gampanel = new TicTacToe(window);
        window.add(gampanel);

        window.setVisible(true);

    }

}
