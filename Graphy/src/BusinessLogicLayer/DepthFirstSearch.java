/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Glebuz
 */
public class DepthFirstSearch {

    private GetNumberOfNodes getNumberOfNodes = new GetNumberOfNodes();
    private CreateTheAdjacencyMatrix createTheAdjacencyMatrix = new CreateTheAdjacencyMatrix();
    private int countOfNodes;
    private int [][] theAdjacencyMatrix;

    private boolean ifStackOfTabOrderIsNull(Stack stackOfTabOrder, boolean[] usedNode) {
        for (int i = 0; i < usedNode.length; i++) {
            if (!usedNode[i]) {
                stackOfTabOrder.push(i);
                usedNode[i] = true;
                return true;
            }

        }
        return false;
    }

    public String depthFirstSearch() {
        System.out.println("-----------------------------------");
        countOfNodes = getNumberOfNodes.getNumberOfNodes();
        createTheAdjacencyMatrix.createTheAdjacencyMatrix(countOfNodes);
        theAdjacencyMatrix = CreateTheAdjacencyMatrix.theAdjacencyMatrix;
        Stack<Integer> stackOfTabOrder = new Stack<>();//стек обхода          
        List<Integer> listOfTabOrder = new LinkedList<>();
        // список порядка обхода
        boolean[] usedNode = new boolean[GetNumberOfNodes.countOfNodes];
        stackOfTabOrder.push(0);// пихаем в стек первую вершину
        usedNode[0] = true;//начинаем обход с первой вершины        
        while (!stackOfTabOrder.empty()
                || ifStackOfTabOrderIsNull(stackOfTabOrder, usedNode)) //до тех пор, пока стек обхода не пуст
        {
            int f = stackOfTabOrder.pop();
            listOfTabOrder.add(f);
            for (int i = 0; i < GetNumberOfNodes.countOfNodes; i++) {
                if (theAdjacencyMatrix[f][i] > 0 && !usedNode[i]) {
                    stackOfTabOrder.push(i);
                    usedNode[i] = true;
                }
            }
        }
        System.out.println(listOfTabOrder);
        return "Depth-first search is done.";
    }
}
