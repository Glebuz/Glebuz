/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Glebuz
 */
public class PrimsAlgorythm {

    private GetNumberOfNodes getNumberOfNodes = new GetNumberOfNodes();
    private CreateTheAdjacencyMatrix createTheAdjacencyMatrix = new CreateTheAdjacencyMatrix();
    private int countOfNodes;
    private int [][] theAdjacencyMatrix;
    private Rib rib = new Rib(0, 0, 0);

    public PrimsAlgorythm() {
    }

    public String Prima() {
        //GetNumberOfNodes getNumberOfNodesPA = new GetNumberOfNodes();
        //nodeCountForPA = getNumberOfNodes.countOfNodes;
        System.out.println("-----------------------------------");
        countOfNodes = getNumberOfNodes.getNumberOfNodes();
        createTheAdjacencyMatrix.createTheAdjacencyMatrix(countOfNodes);
        theAdjacencyMatrix = CreateTheAdjacencyMatrix.theAdjacencyMatrix;
        List<Rib> stBor = new LinkedList<>();// стек обхода
        List<String> minOstDer = new LinkedList<>();// список минимального остовного дерева
        boolean[] usedNodes = new boolean[countOfNodes];
        int startEdgeNumber = 0, finishEdgeNumber = 0, finNumOfNext, weiNum, minWay, maxWay, nextWay = 0;
        boolean countWays = false;
        maxWay = 0;
        minWay = 0;
        for (int i = 0; i < countOfNodes; i++) {
            for (int j = 0; j < countOfNodes; j++) {
                if (theAdjacencyMatrix[i][j] > maxWay) {
                    maxWay = theAdjacencyMatrix[i][j];// находим макс путь
                }
            }
        }
////////////////////////////////////////////////////////////////////////////////        
        startEdgeNumber = 0;
        finNumOfNext = 0;
        minWay = maxWay;

        boolean contin = true; // продолжать = true
////////////////////////////////////////////////////////////////////////////////     
        while (contin == true)// до тех пор, пока продолжать = true
        {
            usedNodes[finNumOfNext] = true;// помечаем исходный как использованный
            minWay = maxWay;// делаем минимальный путь максимальным
            startEdgeNumber = finNumOfNext;
            for (int i = 0; i < countOfNodes; i++)// ищем мин путь дальше
            {
                if (!usedNodes[i] && theAdjacencyMatrix[startEdgeNumber][i] > 0 && theAdjacencyMatrix[startEdgeNumber][i] <= minWay) // если вершина не использовалась и путь меньше минимального и больше нуля 
                {
                    minWay = theAdjacencyMatrix[startEdgeNumber][i];//мин путь == путь текущего ребра
                    finNumOfNext = i;// конечный узел = i
                    countWays = true;// найден путь = 1
                }

            }
            if (countWays == false)// если новых путей не найдено
            {
                int minWei = maxWay;
                int nmb = 0;
                for (int k = stBor.size(); k > 0; k--)// проверяем список обхода с конца
                {
                    rib = stBor.get(k - 1);
                    if (!usedNodes[rib.finishRibNumber] && rib.weightOfRib <= minWei) {
                        startEdgeNumber = rib.startRibNumber;
                        finNumOfNext = rib.finishRibNumber;
                        nmb = k - 1;
                    }

                }
                stBor.remove(nmb);
            }
            countWays = false;
            minOstDer.add(Integer.toString(startEdgeNumber) + "-" + Integer.toString(finNumOfNext));// добавляем ребро в мин ост дер
            usedNodes[startEdgeNumber] = true;

            for (int i = 0; i < countOfNodes; i++) {
                if (theAdjacencyMatrix[startEdgeNumber][i] > 0 && !usedNodes[i]) // если есть путь и узел не использовался, добавляем в стек обхода
                {
                    nextWay = theAdjacencyMatrix[startEdgeNumber][i];// вес следующего пути
                    finishEdgeNumber = i; // конечный узел = i
                    rib.startRibNumber = startEdgeNumber;
                    rib.finishRibNumber = finishEdgeNumber;
                    rib.weightOfRib = nextWay;
                    stBor.add(rib);
                }
            }
            contin = false;
            int i = 0;
            while (i < countOfNodes) {
                if (usedNodes[i] == false) {
                    contin = true;
                    break;
                }
                i++;
            }
        }
        for (int i = 0; i < minOstDer.size() - 1; i++) {
            System.out.print(minOstDer.get(i) + "; ");
        }
        System.out.println();
        return "Prim's algorithm is done.";
    }
}
