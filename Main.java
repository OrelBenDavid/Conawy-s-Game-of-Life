import javax.swing.*;

public class Main {

    public static void main(String[] args) {
//        GOLMatrix A = new GOLMatrix(5);
//        A.flipCell(0, 4);
//        A.flipCell(1, 0);
//        A.flipCell(2, 0);
//        A.flipCell(1, 1);
//        A.flipCell(2, 1);
//        A.flipCell(3, 1);
//        for (int i = 0; i < A.getWorld().length; i++) {
//            for (int j = 0; j < A.getWorld().length; j++) {
//                System.out.print(A.getWorld()[i][j] + " ");
//            }
//            System.out.print("\n");
//        }
//        System.out.print("\n\n");
//        A.nextGeneration();
//        for (int i = 0; i < A.getWorld().length; i++) {
//            for (int j = 0; j < A.getWorld().length; j++) {
//                System.out.print(A.getWorld()[i][j] + " ");
//            }
//            System.out.print("\n");
//        }


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GOLPanel gol=  new GOLPanel(100);
        frame.add(gol);
        frame.setSize(10, 10);
        frame.setVisible(true);

    }
}