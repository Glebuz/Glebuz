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
    public int countOfNodes;
    public int getNumberOfNodes ()// создаем дерево p.s. необходимо ввести кол-во
    {
        System.out.println("Enter the number of nodes: ");
        Scanner in = new Scanner(System.in);
        countOfNodes = 3;//in.nextInt();   
        System.out.println("You entered " + countOfNodes);
        System.out.println("-----------------------------------");
        return countOfNodes;
    }
}
