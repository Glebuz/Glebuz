/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shell;

import java.util.*;
import BusinessLogicLayer.*;

/**
 *
 * @author Glebuz
 */
public class Shell {

    private Shell graphy = new Shell();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int choise = 1;//in.nextInt();
        int choise1;
        while (choise > 0) {
            System.out.println("Menu:");
            System.out.println("0) Try Depth-first search;");
            System.out.println("1) Try Boruvka's algorythm;");
            System.out.println("2) Try Prim's algorythm;");
            System.out.println("3) Exit;");
            choise1 = in.nextInt();
            menu1:
            switch (choise1) {
                case 0: {
                    DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
                    depthFirstSearch.depthFirstSearch();
                }
                break menu1;
                case 1: {
                    BoruvkasAlgorythm boruvkasAlgorythm = new BoruvkasAlgorythm();
                    boruvkasAlgorythm.Boruvki();
                }
                break menu1;
                case 2: {
                    PrimsAlgorythm primsAlgorythm = new PrimsAlgorythm();
                    primsAlgorythm.Prima();
                }
                break menu1;
                case 3: {
                    System.exit(0);
                }
                default:
                    System.out.println("Fail, please try again.");
                    break menu1;
            }
            continue;
        }
    }
}
