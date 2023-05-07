package com.gradedproject2;

import java.util.*;

public class Skyscrapper {
    int no_of_floor;
    List<Integer> floor_size = new LinkedList<>();
    List<Integer> sorted;

    void input() {
        System.out.println("Enter the number of floors.");
        try{
            Scanner sc = new Scanner(System.in);
            no_of_floor = sc.nextInt();
            for (int i = 0; i < no_of_floor; i++) {
                System.out.println("Enter the floor's size ");
                int size = sc.nextInt();
                floor_size.add(size);
            }

        }catch (InputMismatchException e){
            System.out.println("InputMismatchException : Only numeric value required : "+ e.getMessage());
        }


        System.out.println("input list : " + floor_size);
        sorted = new LinkedList<>(floor_size);
        Collections.sort(sorted, Collections.reverseOrder());
        System.out.println("sortedlist : " + sorted);
        List<Integer> day_construction = new LinkedList<>();
        List<Integer> floor_construction = new LinkedList<>();
        int day = 0;
        int indx = 0;
        List<Integer> construction_floor_available = new LinkedList<>();
        try{
            for (int j = 0; j < sorted.size(); j++) {
                int floor = sorted.get(j);
                if (construction_floor_available.contains(floor) == true) {
                    System.out.println("Day : " + day + " : floor construction " + floor);
                    day_construction.add(day);
                    construction_floor_available.remove(Integer.valueOf(floor));
                } else {
                    while (construction_floor_available.contains(floor) == false) {
                        if (day > 0 && day_construction.contains(day) == false) {
                            System.out.println("day : " + day + " : no construction as floor " + floor + " is not ready yet");
                            floor_construction.add(0);
                        }
                        day = day + 1;
                        int ready_floor = floor_size.get(indx);
                        indx = indx + 1;
                        construction_floor_available.add(ready_floor);
                    }
                    System.out.println("day : " + day + " : floor construction " + floor);
                    construction_floor_available.remove(Integer.valueOf(floor));
                    day_construction.add(day);
                    //floor_construction.add()
                }

            }

        }catch (IndexOutOfBoundsException e){
            System.out.println("Index Out Of Bound : "+ e.getMessage());
        }finally {
            System.out.println("Construction done");
        }

    }
}