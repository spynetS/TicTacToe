import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TicTacToe extends JPanel {

    JFrame frame;
    ArrayList<ArrayList<Container>> rows = new ArrayList<>();
    ArrayList<ArrayList<Container>> columns = new ArrayList<>();
    int turn=0;

    public TicTacToe(JFrame frame)
    {
        this.frame = frame;
        InitializeColumns();
        InitializeRows();
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                SetContainer(e.getX(),e.getY());
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

    }
    private void InitializeColumns() {
        columns.clear();
        for(int i = 0; i< 3;i++) {
            ArrayList<Container> a = new ArrayList<>();
            a.add(null);
            a.add(null);
            a.add(null);
            columns.add(a);
        }
    }

    private void InitializeRows() {
        rows.clear();
        for(int i = 0; i< 3;i++) {
            ArrayList<Container> a = new ArrayList<>();
            a.add(null);
            a.add(null);
            a.add(null);
            rows.add(a);
        }
    }

    private void GameOver(Container.Form winner) {   if(winner!= Container.Form.n)
            System.out.println("Winner is "+winner);
        else
            System.out.println("Draw");
        InitializeColumns();
        InitializeRows();
        repaint();
    }

    private boolean HasWon() {
        //Check the rows
        for(int i = 0; i< rows.size();i++) {
            int sumx=0;
            int sumo =0;
            for(int ii = 0; ii< rows.get(i).size();ii++) {
                if(rows.get(i).get(ii)!=null&&rows.get(i).get(ii).getForm()== Container.Form.x) {
                    sumx++;
                }
                else if(rows.get(i).get(ii)!=null&&rows.get(i).get(ii).getForm()==Container.Form.o) {
                    sumo++;
                }
                if(sumo==3) {
                    GameOver(Container.Form.o);
                }
                else if(sumx==3) {
                    GameOver(Container.Form.x);
                }
            }
        }
        //Checks the columns
        for(int i = 0; i< columns.size(); i++) {
            int sumx=0;
            int sumo =0;
            for(int ii = 0; ii< columns.get(i).size(); ii++) {
                if(columns.get(i).get(ii)!=null&& columns.get(i).get(ii).getForm()== Container.Form.x) {
                    sumx++;
                }
                else if(columns.get(i).get(ii)!=null&& columns.get(i).get(ii).getForm()==Container.Form.o) {
                    sumo++;
                }
                if(sumo==3) {
                    GameOver(Container.Form.o);
                }
                else if(sumx==3) {
                    GameOver(Container.Form.x);
                }
            }
        }
        int sumx=0;
        int sumo =0;
        //Check diaginal \
        for(int i = 0; i< rows.size(); i++) {
            if(rows.get(i).get(i)!=null&&rows.get(i).get(i).getForm()== Container.Form.x) {
                sumx++;
                System.out.println(rows.get(i).get(i).getForm());
            }
            else if(rows.get(i).get(i)!=null&&rows.get(i).get(i).getForm()== Container.Form.o) {
                System.out.println(rows.get(i).get(i).getForm());
                sumo++;
            }
            if(sumo==3) {
                GameOver(Container.Form.o);
            }
            else if(sumx==3) {
                GameOver(Container.Form.x);
            }
        }
        //Check diaginal /
        sumo = 0;
        sumx = 0;
        for(int i = 0; i< rows.size(); i++) {
            if(rows.get(i).get(2-i)!=null&&rows.get(i).get(2-i).getForm()== Container.Form.x) {
                sumx++;
                System.out.println(rows.get(i).get(2-i).getForm());
            }
            else if(rows.get(i).get(2-i)!=null&&rows.get(i).get(2-i).getForm()== Container.Form.o) {
                System.out.println(rows.get(i).get(2-i).getForm());
                sumo++;
            }
            if(sumo==3) {
                GameOver(Container.Form.o);
            }
            else if(sumx==3) {
                GameOver(Container.Form.x);
            }
        }

        int partsum=0;
        //Check if the board is full
        for(int i = 0; i< rows.size();i++) {
            for(int ii = 0; ii< rows.get(i).size();ii++) {
               if(rows.get(i).get(ii)!=null) {
                   partsum++;
               }
               if(partsum==9)
                GameOver(Container.Form.n);
            }
        }

        return false;
    }

    private int[] GetContainer(int x, int y) {
        int heightD = frame.getHeight()/3;
        int widthD = frame.getWidth()/3;
        //Row one
        if(x<widthD&&y<heightD)
        {
            return new int[]{0,0};
        }
        else if(x>=widthD&&x<widthD*2&&y<heightD)
        {
            return new int[]{widthD,0};
        }
        else if(x>=widthD*2&&y<heightD)
        {
            return new int[]{widthD*2,0};
        }
        //Row 2
        else if(x<widthD&&y<heightD*2)
        {
            return new int[]{0,heightD};
        }
        else if(x>=widthD&&x<widthD*2&&y<heightD*2)
        {
            return new int[]{widthD,heightD};
        }
        else if(x>=widthD*2&&y<heightD*2)
        {
            return new int[]{widthD*2,heightD};
        }
        //Row 4
        else if(x<widthD&&y<heightD*3)
        {
            return new int[]{0,heightD*2};
        }
        else if(x>=widthD&&x<widthD*2&&y<heightD*3)
        {
            return new int[]{widthD,heightD*2};
        }
        else if(x>=widthD*2&&y<heightD*3)
        {
            return new int[]{widthD*2,heightD*2};
        }
        return null;
    }

    public boolean canSet(Container newContainer) {
        for(int i = 0; i<rows.get(newContainer.y).size();i++){
            if(rows.get(newContainer.y).get(newContainer.x)==null){
               return true;
           }
        }
        return false;
    }

    private void SetContainer(int x, int y) {
        Container newContainer = new Container();
        newContainer.x=GetContainer(x,y)[0]/(frame.getWidth()/3);
        newContainer.y=GetContainer(x,y)[1]/(frame.getHeight()/3);
        newContainer.setShow(true);
        if(canSet(newContainer)){
            if(turn%2==0)
                newContainer.setForm(Container.Form.x);// sets to x
            else
                newContainer.setForm(Container.Form.o); // sets to o

            //Adds to the row array
            for(int i = 0; i<rows.get(newContainer.y).size();i++){
                rows.get(newContainer.y).set(newContainer.x,newContainer);
            }
            //Adds to the columns array
            for(int i = 0; i<columns.get(newContainer.x).size();i++){
                columns.get(newContainer.x).set(newContainer.y,newContainer);
            }
            turn++;
            HasWon();
        }
        repaint();
    }

    private void DrawGamePanel(Graphics g)
    {
        int heightD = frame.getHeight()/3-15;
        int widthD = frame.getWidth()/3;
        int x =0;
        int y = 0;
        for(int i =0;i<rows.size();i++)
        {
            for(int ii =0;ii<rows.get(i).size();ii++)
            {
                try{
                    if(rows.get(i).get(ii)!=null&&rows.get(i).get(ii).isShow()&&rows.get(i).get(ii).getForm()==Container.Form.o){
                        g.drawOval(x*widthD,y*heightD,widthD,heightD);
                    }

                    else if(rows.get(i).get(ii)!=null&&rows.get(i).get(ii).isShow()){
                        g.drawLine(x*widthD,y*heightD,x*widthD+widthD,y*heightD+heightD);
                        g.drawLine(x*widthD+widthD,y*heightD,x*widthD,y*heightD+heightD);
                    }
                }
                catch (Exception e){e.printStackTrace();}
                    g.drawRect(x*widthD,y*heightD,widthD,heightD);
                x++;
                if(x==3)
                {
                    x=0;
                    y++;
                }
            }

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawGamePanel(g);
    }
}
