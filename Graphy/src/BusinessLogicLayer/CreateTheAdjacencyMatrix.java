/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import java.util.Random;

/**
 *
 * @author Glebuz
 */
public class CreateTheAdjacencyMatrix {

    //public static final GetNumberOfNodes getNumberOfNodes = new GetNumberOfNodes();
    public static int[][] theAdjacencyMatrix;//матрица смежности
    private static Random random = new Random();

    public int[][] createTheAdjacencyMatrix(int numberOfNodes)// создаем матрицу смежности
    {
        //int numberOfNodes = GetNumberOfNodes.getNumberOfNodes(1);
        theAdjacencyMatrix =
                new int[numberOfNodes][numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++)//цикл заполнения
        {
            for (int j = i + 1; j < numberOfNodes; j++) {
                theAdjacencyMatrix[i][j] = random.nextInt(10);
                theAdjacencyMatrix[j][i] = theAdjacencyMatrix[i][j];
                //симметрично заполняем матрицу
            }
        }
        System.out.println("The adjacency matrix is: ");
        //вывод матрицы
        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                System.out.print(theAdjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Creating of adjacency matrix. Ok.");
        //уведомление о создании матрицы
        return theAdjacencyMatrix;
    }
}
