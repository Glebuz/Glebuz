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
public class Shell 
{
    private Shell graphy = new Shell();
    
    public static void main(String args[]) 
    { 
        Scanner in = new Scanner(System.in);  
        int choise = 1;//in.nextInt();
        int choise1;
        while(choise > 0)
        {
            System.out.println("\u001b[2J");
            System.out.println("Menu:");
            System.out.println("0) Try Depth-first search;");
            System.out.println("1) Try Boruvka's algorythm;");
            System.out.println("2) Try Prim's algorythm;");            
            System.out.println("3) Exit;");
            choise1 = in.nextInt();
            menu1: switch(choise1)
            {
                case 0:
                {
                    CreateTheAdjacencyMatrix createTheAdjacencyMatrix = new CreateTheAdjacencyMatrix();
                    createTheAdjacencyMatrix.createTheAdjacencyMatrix();
                    DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
                    depthFirstSearch.depthFirstSearch();
                }
                    break menu1;
                case 1:
                {
                    CreateTheAdjacencyMatrix createTheAdjacencyMatrix = new CreateTheAdjacencyMatrix();
                    createTheAdjacencyMatrix.createTheAdjacencyMatrix();
                    BoruvkasAlgorythm boruvkasAlgorythm = new BoruvkasAlgorythm(choise, choise, choise);
                    boruvkasAlgorythm.Boruvki();
                }
                    break menu1;
                case 2:
                {
                    CreateTheAdjacencyMatrix createTheAdjacencyMatrix = new CreateTheAdjacencyMatrix();
                    createTheAdjacencyMatrix.createTheAdjacencyMatrix();
                    PrimsAlgorythm primsAlgorythm = new PrimsAlgorythm(choise, choise, choise);
                    primsAlgorythm.Prima();
                }
                    break menu1;
                case 3:
                {
                    System.exit(0);
                }
                default: System.out.println("Fail, please try again.");
                    break menu1;
            }
            continue;
        }
    }
}
