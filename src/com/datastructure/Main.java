package com.datastructure;

import com.datastructure.array.MidArray;
import com.datastructure.array.PriArray;
import com.datastructure.array.SenArray;

public class Main {


    public static void main(String[] args){

        SenArray<Integer> array = new SenArray<>();
        for (int i = 0; i < 10; i++){
            array.addLast(i);
        }
        array.addLast(5);
        array.addFirst(5);
        System.out.println(array);
        array.set(1, 5);
        System.out.println(array);
        System.out.println(array.contains(3));
        System.out.println(array.find(3));

        array.remove(3);
        System.out.println(array);

        array.removeFirst();
        System.out.println(array);

        array.removeElement(5);
        System.out.println(array);


    }
}
