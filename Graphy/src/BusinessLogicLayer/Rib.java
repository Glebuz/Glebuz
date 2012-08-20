/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

/**
 *
 * @author Glebuz
 */
public class Rib {

    protected int startRibNumber, finishRibNumber, weightOfRib;

    Rib(int startEdgeNumber, int finishEdgeNumber, int nextWay) {
        startRibNumber = startEdgeNumber;
        finishRibNumber = finishEdgeNumber;
        weightOfRib = nextWay;
    }
}