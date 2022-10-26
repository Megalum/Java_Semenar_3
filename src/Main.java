import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Integer> myArray = new ArrayList<>();
        Logger logger = Logger.getAnonymousLogger();
        myArray.add(random.nextInt(100));
        myArray.add(random.nextInt(100));
        myArray.add(random.nextInt(100));
        myArray.add(random.nextInt(100));
        myArray.add(random.nextInt(100));
        myArray.add(random.nextInt(100));
        myArray.add(random.nextInt(100));
        logger.info(minMaxEverage(myArray).toString());     //Задание 3
        logger.info(sortMerge(myArray).toString());         //Задание 1
        logger.info(dellEvenNumbers(myArray).toString());   //Задание 2

    }

    private static List<Integer> sortMerge(List<Integer> array){
        if (array.size() == 1 | array.size() == 0){ 
            return array;
        }
        List<Integer> left = new ArrayList<>();
        int i = 0;
        for ( ; i < array.size() / 2; i++){ 
            left.add(array.get(i));
        }
        left = sortMerge(left);
        List<Integer> right = new ArrayList<>();
        for ( ; i < array.size(); i++){ 
            right.add(array.get(i));
        }
        right = sortMerge(right);       
        int n = 0, m =0;
        List<Integer> c = new ArrayList<>();
        while (n < left.size() & m < right.size()){ 
            if (left.get(n) <= right.get(m)){ 
                c.add(left.get(n++));
            }
            else{ 
                c.add(right.get(m++)); 
            }
        }
        while (n < left.size()){ 
            c.add(left.get(n++)); 
        }
        while (m < right.size()){ 
            c.add(right.get(m++)); 
        }
        for (i = 0; i < array.size(); i++){ 
            array.set(i, c.get(i));
        }
        return array;
    }

    private static List<Integer> dellEvenNumbers(List<Integer> array){
        for (int i = 0; i < array.size(); ) {
            if (array.get(i) % 2 == 0){ 
                array.remove(i);
            }
            else{ 
                i++;
            }
        }
        return array;
    }

    private static List<String> minMaxEverage(List<Integer> array){
        List<String> output = new ArrayList<>();
        int min = array.get(0);
        int max = array.get(0);
        int everage = array.get(0);
        for (int i = 1; i < array.size(); i++) {
            if (min > array.get(i)){
                min = array.get(i);
            }
            if (max < array.get(i)){
                max = array.get(i);
            }
            everage += array.get(i);
        }
        everage /= array.size();
        output.add("Min -> " + min);
        output.add("Max -> " + max);
        output.add("Everage -> " + everage);
        return output;
    }

}