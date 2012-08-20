/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

/**
 *
 * @author Glebuz
 */
public class BoruvkasAlgorythm {

    //private GetNumberOfNodes getNumberOfNodes = new GetNumberOfNodes();
    private CreateTheAdjacencyMatrix createTheAdjacencyMatrix = new CreateTheAdjacencyMatrix();
    private Rib rib = new Rib(0, 0, 0);

    public BoruvkasAlgorythm() {
    }

    public String Boruvki() {
        System.out.println("-----------------------------------");
        int countOfNodes = GetNumberOfNodes.getNumberOfNodes();
        createTheAdjacencyMatrix.createTheAdjacencyMatrix(countOfNodes);
        int theAdjacencyMatrix[][] = createTheAdjacencyMatrix.theAdjacencyMatrix;
        int[] usedNodes = new int[countOfNodes];// массив пометок использования вершин
        for (int i = 0; i < countOfNodes; i++) {
            usedNodes[i] = i + 1;
        }
        int maxWeight = -1;
        // найдем максимальное ребро
        for (int i = 0; i < countOfNodes; i++) {
            for (int j = 0; j < countOfNodes; j++) {
                if (theAdjacencyMatrix[i][j] > maxWeight) {
                    maxWeight = theAdjacencyMatrix[i][j] + 1;// находим макс ребро
                }
            }
        }
        // цикл
        boolean contin = true;
        rib.startRibNumber = -1;
        rib.finishRibNumber = -1;
        while (contin == true) {
            contin = false;
            int minWeight = maxWeight;
            for (int i = 0; i < countOfNodes; i++) {
                for (int j = i + 1; j < countOfNodes; j++) {
                    if ((theAdjacencyMatrix[i][j] < minWeight)
                            && (theAdjacencyMatrix[i][j] > 0)
                            && (usedNodes[i] != usedNodes[j])) // если путь меньше минпути и путь существует и это не путь в самого себя
                    {
                        minWeight = theAdjacencyMatrix[i][j];//обновляем 
                        rib.startRibNumber = i;// запоминаем первую вершину
                        rib.finishRibNumber = j;// запоминаем вторую вершину
                        contin = true;// нашли минимальный возможный путь
                    }
                }
            }
            if (contin == true)//Если нашли возможный минимальный путь
            {
                theAdjacencyMatrix[rib.startRibNumber][rib.finishRibNumber] = 0;
                //помечаем путь, как использованный
                int numbComp = usedNodes[rib.startRibNumber];
                //запоминаем номер компоненты
                int changedComp = usedNodes[rib.finishRibNumber];
                // запоминаем номер компоненты
                if (usedNodes[rib.startRibNumber] > usedNodes[rib.finishRibNumber]) 
                // если если номер компоненты 1 > 2 меняем их местами
                {
                    numbComp = usedNodes[rib.finishRibNumber];
                    changedComp = usedNodes[rib.startRibNumber];
                }
                for (int i = 0; i < countOfNodes; i++) {
                    if (usedNodes[i] == changedComp) {
                        usedNodes[i] = numbComp;
                        //переписываем все 2-ые компоненты под первые
                    }
                }
                contin = false;
                // перед проверкой, что все вершины не принадлежат елинственной компоненте
                for (int i = 0; i < countOfNodes; i++) {
                    if (usedNodes[i] > 1)// если какой либо узел больше чем 1
                    {
                        contin = true;// имеет смысл продолжать
                        break;
                    }
                }
                System.out.print(rib.startRibNumber);// вывод ребра              
                System.out.print("-");
                System.out.print(rib.finishRibNumber);
                System.out.print("; ");

            }

        }
        System.out.println();
        return "Boruvka's algorithm is done";
    }
}
