import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GOLPanel extends JPanel {
    private GOLMatrix logic;
    private JButton cmdGo, cmdNext, cmdClear, cmdFaster, cmdSlower;
    private JButton[] buttons;
    private Timer time;
    private Label lblGenerations;
    private int Interval;
    public GOLPanel(int worldSize){
        logic = new GOLMatrix(worldSize);
        cmdGo = new JButton("Go");
        cmdNext = new JButton("Next");
        cmdClear = new JButton("Clear");
        cmdSlower = new JButton("Slower");
        cmdFaster = new JButton("Faster");
        lblGenerations = new Label("Number of generations:"+logic.getGenerations());
        Interval = 200;

        cmdGo.setEnabled(true);
        cmdNext.setEnabled(true);
        cmdClear.setEnabled(true);
        cmdSlower.setEnabled(false);
        cmdFaster.setEnabled(false);

        Listener lis = new Listener();
        time = new Timer(Interval,lis);
        cmdGo.addActionListener(lis);
        cmdNext.addActionListener(lis);
        cmdClear.addActionListener(lis);
        cmdFaster.addActionListener(lis);
        cmdSlower.addActionListener(lis);



        JPanel north = new JPanel();
        north.add(lblGenerations);
        north.add(cmdGo);
        north.add(cmdNext);
        north.add(cmdClear);
        north.add(cmdFaster);
        north.add(cmdSlower);
        JPanel center = new JPanel();
        buttons = new JButton[worldSize*worldSize];
        center.setLayout(new GridLayout(worldSize,worldSize));
        for (int i = 0; i<worldSize*worldSize ; i++)
             {
                buttons[i] = new JButton();
                buttons[i].addActionListener(lis);
                buttons[i].setBackground(Color.white);
                center.add(buttons[i]);
            }

        setLayout(new BorderLayout());
        add(north,BorderLayout.NORTH);
        add(center,BorderLayout.CENTER);


    }
    public void paintsquare(){

        int counter = 0;
        for (int i = 0; i<logic.getWorld().length; i++)
            for (int j = 0; j<logic.getWorld().length; j++) {
                if (logic.getWorld()[i][j]) {
                    buttons[counter].setBackground(Color.BLUE);
                }
                else {
                    buttons[counter].setBackground(Color.white);
                }
                counter++;
            }
    }

    private class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < logic.getWorld().length*logic.getWorld().length; i++) {

                if (e.getSource() == buttons[i]) {
                    logic.flipCell(i / logic.getWorld().length, i - (i / logic.getWorld().length) * logic.getWorld().length);
                    paintsquare();

                }
            }

            if (e.getSource() == cmdNext){
                logic.nextGeneration();
                logic.generations += 1;
                lblGenerations.setText("Number of generations:"+logic.getGenerations());
                paintsquare();
            }

            else if (e.getSource() == time){


                logic.nextGeneration();
                logic.generations += 1;
                lblGenerations.setText("Number of generations:"+logic.getGenerations());
                paintsquare();


                }

            else if(e.getSource() == cmdGo) {
                if (!time.isRunning()) {
                    cmdGo.setText("stop");
                    cmdClear.setEnabled(false);
                    cmdNext.setEnabled(false);
                    cmdSlower.setEnabled(true);
                    cmdFaster.setEnabled(true);
                    time.start();
                } else {
                    cmdGo.setText("Go");
                    cmdClear.setEnabled(true);
                    cmdNext.setEnabled(true);
                    cmdSlower.setEnabled(false);
                    cmdFaster.setEnabled(false);
                    time.stop();
                }
            }
            else if (e.getSource() == cmdClear) {
                logic.clearWorld();
                lblGenerations.setText("Number of generations:"+logic.getGenerations());
                paintsquare();
            }



            else if (e.getSource() == cmdFaster) {
                if (Interval > 100) {
                    Interval = Interval - 20;
                    time.setDelay(Interval);
                }
            }

            else if (e.getSource() == cmdSlower) {
                if (Interval < 1000) {
                    Interval = Interval + 20;
                    time.setDelay(Interval);
                }
            }

            }


        }
    }



