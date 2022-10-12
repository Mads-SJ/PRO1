package model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MethodsArrayList {
    
    /**
     *
     * @param list
     * @return sums the mumbers in the list using a for loop
     */
    public int sumListe(ArrayList<Integer> list) {
        int resultat = 0;
        for (int i = 0; i < list.size(); i++) {
        	int tal = list.get(i);
            resultat = resultat + list.get(i);
        }
        return resultat;
    }
    
    /**
    *
    * @param list
    * @return sums the mumbers in the list using a forEach loop
    */
    public int sumListe2(ArrayList<Integer> list) {
        int resultat = 0;
        for (int tal : list) {
            resultat = resultat + tal;
        }
        return resultat;
    }
    
    /**
     *
     * @param list
     * @return index at the first even number
     */
    public int hasEvenAtIndex(ArrayList<Integer> list) {
        int index = -1;
        int i = 0;
        while (index == -1 && i < list.size()) {
            if (list.get(i) % 2 == 0) {
                index = i;
            }
            i++;
        }
        return index;
        
    }

    public int min(ArrayList<Integer> list) {
        int min = Integer.MAX_VALUE;

        for (int n : list) {
            if (n < min) {
                min = n;
            }
        }
        return min;
    }

    public double average(ArrayList<Integer> list) {
        int sum = 0;
        double avg = 0.0;

        for (int n : list) {
            sum += n;
        }

        if (list.size() > 0) {
            avg = (double) sum / list.size();
        }
        return avg;
    }

    public int countZeros(ArrayList<Integer> list) {
        int numberOfZeros = 0;

        for (int n : list) {
            if(n == 0) {
                numberOfZeros++;
            }
        }
        return numberOfZeros;
    }

    public void swapEvenWithZeros(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.set(i, 0);
            }
        }
    }

    public ArrayList<Integer> aEvenList(ArrayList<Integer> list) {
        ArrayList<Integer> evenList = new ArrayList<>();
        for (int n : list) {
            if (n % 2 == 0) {
                evenList.add(n);
            }
        }
        return evenList;
    }
}
