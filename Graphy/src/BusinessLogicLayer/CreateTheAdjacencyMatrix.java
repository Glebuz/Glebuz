/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;
/**
 *
 * @author Glebuz
 */
public class CreateTheAdjacencyMatrix extends RandomNumberGenerator{
    public static final GetNumberOfNodes getNumberOfNodes = new GetNumberOfNodes();
    public static int countOfNodes;
    public static int [] [] theAdjacencyMatrix;
    public void createTheAdjacencyMatrix ()// создаем матрицу смежности
    {
        
        countOfNodes = getNumberOfNodes.getNumberOfNodes();
        theAdjacencyMatrix = new int [countOfNodes] [countOfNodes];
        for (int i = 0; i < countOfNodes; i++ )
        {        
            for (int j = i+1; j < countOfNodes; j++)
            {
                theAdjacencyMatrix [i][j] = RandomNumberGenerator.generate();
                theAdjacencyMatrix [j][i] = theAdjacencyMatrix [i][j];                
            }  
        }
        System.out.println("The adjacency matrix is: ");
        for (int i = 0; i < countOfNodes; i++)
        {
            for (int j = 0; j < countOfNodes; j++)
            {
                System.out.print(theAdjacencyMatrix [i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Creating of adjacency matrix. Ok.");
    }
}
