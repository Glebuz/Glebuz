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
public class DepthFirstSearch extends CreateTheAdjacencyMatrix{
    private boolean ifStackOfTabOrderIsNull(Stack st, boolean [] usedNode) 
    {
        for (int i = 0; i < usedNode.length; i++)
        {
            if (!usedNode [i]) 
            {
                st.push(i); 
                usedNode[i] = true;
                return true;
            }
            
        }
        return false;
    }
    public String depthFirstSearch ()
    {
        System.out.println("-----------------------------------");
        Stack <Integer> stackOfTabOrder = new Stack <>();//стек обхода          
        List <Integer> listOfTabOrder = new LinkedList <> ();
        // список порядка обхода
        boolean [] usedNode = new boolean [countOfNodes];
        stackOfTabOrder.push(0);// пихаем в стек первую вершину
        usedNode [0] = true;//начинаем обход с первой вершины        
        while(!stackOfTabOrder.empty() 
                || ifStackOfTabOrderIsNull(stackOfTabOrder, usedNode))
        //до тех пор, пока стек обхода не пуст
        {
            int f = stackOfTabOrder.pop();           
            listOfTabOrder.add(f);
            for (int i = 0; i < countOfNodes; i++)
            {
                if (theAdjacencyMatrix[f][i] > 0 && !usedNode[i])
                {
                    stackOfTabOrder.push(i);
                    usedNode [i] = true;
                }
            }
        }
        System.out.println(listOfTabOrder);
        return "Depth-first search is done.";
    }
}
