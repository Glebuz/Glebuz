/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogicLayer;

/**
 *
 * @author Glebuz
 */
public class BoruvkasAlgorythm extends Rebro{

    public BoruvkasAlgorythm(int startEdgeNumber, int finishEdgeNumber, int nextWay) {
        super(startEdgeNumber, finishEdgeNumber, nextWay);
    }
    
     public String Boruvki ()
    {
        
        System.out.println("-----------------------------------");
        int [] usedNodes = new int [countOfNodes];// массив пометок использованности вершин
        for (int i = 0; i < countOfNodes; i++)
        {
            usedNodes [i] = i + 1;
        }
        int maxRebro = -1;
        // найдем максимальное ребро
        for (int i = 0; i < countOfNodes; i++)
        {
            for (int j = 0; j < countOfNodes; j++)
            {
                if (theAdjacencyMatrix[i][j] > maxRebro) maxRebro = theAdjacencyMatrix[i][j] + 1;// находим макс ребро
            }
        }        
        // цикл
        boolean contin = true;
        int minVersh1 = -1, minVersh2 = -1;
        while (contin == true)
        {
            contin = false;
            int minRebro = maxRebro;
            for (int i = 0; i < countOfNodes; i++)
            {
                for (int j = i + 1; j < countOfNodes; j++)
                {
                    if((theAdjacencyMatrix[i][j] < minRebro) && (theAdjacencyMatrix[i][j] > 0) && (usedNodes[i] != usedNodes[j]))
                        // если путь меньше минпути и путь существует и это не путь в самого себя
                    {                        
                        minRebro = theAdjacencyMatrix[i][j];//обновляем 
                        minVersh1 = i;// запоминаем первую вершину
                        minVersh2 = j;// запоминаем вторую вершину
                        contin = true;// имеет смысл продолжать
                    }
                }
            }
            if (contin == true)
            {
                theAdjacencyMatrix[minVersh1][minVersh2] = 0;
                int numbComp = usedNodes[minVersh1];//запоминаем номер компоненты
                int changedComp = usedNodes[minVersh2];// запоминаем номер компоненты
                if (usedNodes[minVersh1] > usedNodes[minVersh2])// если если номер компоненты 1 > 2 меняем их местами
                {
                    numbComp = usedNodes[minVersh2];
                    changedComp = usedNodes[minVersh1];
                }
                for (int i = 0; i < countOfNodes; i++)
                {
                    if (usedNodes[i] == changedComp) usedNodes[i] = numbComp;//переписываем все 2-ые компоненты под первые
                }
                contin = false;// перед проверкой, что все вершины не принадлежат елинственной компоненте
                for (int i = 0; i < countOfNodes; i++)
                {
                    if (usedNodes[i] > 1)// если какой либо узел больше чем 1
                    {
                        contin = true;// имеет смысл продолжать
                        break;
                    }
                }
                System.out.print(minVersh1);// вывод ребра              
                System.out.print("-");              
                System.out.print(minVersh2);
                System.out.print("; ");
                
            }
            
        }
        System.out.println();
        return "Boruvka's algorithm is done";
    }

}
