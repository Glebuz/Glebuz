/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import java.util.Scanner;

/**
 *
 * @author Glebuz
 */
public class GetNumberOfNodes {

    public static int countOfNodes;

    protected int getNumberOfNodes()// создаем дерево p.s. необходимо ввести кол-во
    {
        do {
            System.out.println("Enter the number of nodes: ");
            Scanner in = new Scanner(System.in);
            countOfNodes = -1;
            try {
                countOfNodes = in.nextInt();
            } catch (Exception e) {
                System.err.println("Error. You enter not a number");
            }
        } while (countOfNodes < 1);
        System.out.println("You entered " + countOfNodes);
        System.out.println("-----------------------------------");
        return countOfNodes;
    }
}
