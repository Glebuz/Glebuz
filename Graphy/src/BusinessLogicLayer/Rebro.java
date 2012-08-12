/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import BusinessLogicLayer.*;
/**
 *
 * @author Glebuz
 */
public class Rebro extends CreateTheAdjacencyMatrix{
        public int startNode, finishNode, weightOfNode;

    Rebro(int startEdgeNumber, int finishEdgeNumber, int nextWay)
    {
            startNode = startEdgeNumber;
            finishNode = finishEdgeNumber;
            weightOfNode = nextWay;
    }
}
