package com.sevenet.stronaposrednia;

import java.util.*;
import java.util.stream.Collectors;

public class LSN {

    public static void main(String[] args) {

        List<Integer> task1Input = new ArrayList<>(Arrays.asList(1, 10, 20, 20, 2, 5));
        List<Integer> task2Input = new ArrayList<>(Arrays.asList(1, 2, 10, 7, 5, 3, 6, 6, 13, 0));
        task1(task1Input);
        task2(task2Input);
        // w 3 zadaniu podajemy liczbe wierzchołkow, klikamy enter i potem po każdej wartości liczbowej też klikamy enter
        task3();


    }

    static void task1(List<Integer> integerList) {
        List<Integer> distinctList = integerList.stream().distinct().collect(Collectors.toList());
        Collections.sort(distinctList);
        int minValue = distinctList.get(0);
        int maxValue = distinctList.get(distinctList.size() - 1);
        System.out.println("TASK 1: \n");
        for (Integer value : distinctList) {
            System.out.print(value + " ");
        }
        System.out.println("\ncount: " + integerList.size());
        System.out.println("distinct: " + distinctList.size());
        System.out.println("min: " + minValue);
        System.out.println("max: " + maxValue);
    }

    static void task2(List<Integer> integerList) {
        System.out.println("\nTASK 2:\n");
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i <integerList.size(); i++){
            for(int j=0;j<integerList.size(); j++ ){
                if(j==i){
                    continue;
                }
                int firstElement = integerList.get(i);
                int secondElement = integerList.get(j);
                if(firstElement+secondElement==13){
                    if(firstElement<secondElement){
                        resultList.add(new ArrayList<>(Arrays.asList(firstElement,secondElement)));
                    }
                    else{
                        resultList.add(new ArrayList<>(Arrays.asList(secondElement,firstElement)));
                    }
                    integerList.remove(j);

                }
            }
        }
        Collections.sort(resultList, new ListComparator<>());
        for(List<Integer> outerList : resultList){
            for(int value : outerList){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
    static void task3(){
        System.out.println("\n TASK 3: \n");
        Scanner scanner = new Scanner(System.in);
        Map<Integer,Integer> vertices = new HashMap<>();
        List<Integer> firstElements = new ArrayList<>();
        List<Integer> secondElements = new ArrayList<>();
        List<List<Integer>> listOfVertices = new ArrayList<>();
        System.out.println(" enter number of vertices: ");
        int numberOfVertices = 0;
        try {
            numberOfVertices= Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException ex){
            System.out.println("its not a number!");
        }
        for (int i =1; i<=numberOfVertices; i++){
            System.out.println("enter " + i + " vertice");
            int numberOne = Integer.parseInt(scanner.nextLine());
            int numberTwo = Integer.parseInt(scanner.nextLine());
            listOfVertices.add(Arrays.asList(numberOne,numberTwo));
            firstElements.add(numberOne);
            secondElements.add(numberTwo);
            vertices.put(numberOne,numberTwo);
        }
        System.out.println(vertices.size());
        int counter =0;
        if(vertices.size()>0){
            counter = 1;
        }
        for(Integer firstElement : firstElements){
            boolean isConnected = false;
            for(Integer secondElement  : secondElements){
                if(firstElement==secondElement){
                    isConnected=true;
                }

            }
            if(isConnected){
                counter++;
            }
        }
        System.out.println(counter);
    }
}
class  ListComparator<T extends Comparable<T>> implements  Comparator<List<T>> {
    @Override
    public int compare(List<T> o1, List<T> o2) {
        for (int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
            int c = o1.get(i).compareTo(o2.get(i));
            if (c != 0) {
                return c;
            }
        }
        return Integer.compare(o1.size(), o2.size());
    }

}



