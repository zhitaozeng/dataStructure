package com.datastructure;

import com.datastructure.array.Array1;

public class Main {


    public static void main(String[] args){

        Array1 array = new Array1(20);
        for (int i = 0; i < 20; i++){
            array.addLast(i);
        }
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
