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
    protected static int[][] theAdjacencyMatrix;//матрица смежности
    private static Random random = new Random();

    protected void createTheAdjacencyMatrix(int countOfNodes)// создаем матрицу смежности
    {
        theAdjacencyMatrix =
                new int[countOfNodes][countOfNodes];
        for (int i = 0; i < countOfNodes; i++)//цикл заполнения
        {
            for (int j = i + 1; j < countOfNodes; j++) {
                theAdjacencyMatrix[i][j] = random.nextInt(10);
                theAdjacencyMatrix[j][i] = theAdjacencyMatrix[i][j];
                //симметрично заполняем матрицу
            }
        }
        System.out.println("The adjacency matrix is: ");
        //вывод матрицы
        for (int i = 0; i < countOfNodes; i++) {
            for (int j = 0; j < countOfNodes; j++) {
                System.out.print(theAdjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Creating of adjacency matrix. Ok.");
        //уведомление о создании матрицы
    }

    protected int[][] returnTheAdjacencyMatrix() {
        return theAdjacencyMatrix;
    }
}
