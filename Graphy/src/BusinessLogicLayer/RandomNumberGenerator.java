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
public class RandomNumberGenerator extends GetNumberOfNodes{   
    private static Random random = new Random();  
    public static int generate ()// генератор случайных чисел            
    {
        return Math.abs(random.nextInt() % 10);
    }
}
