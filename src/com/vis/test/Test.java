package com.vis.test;


import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Karthika", "Pavithra", "Anusha", "Vinothini","Sowmya","Pavithra");


        System.out.println(names.stream().count());
        System.out.println(names.stream().filter(name-> !name.equalsIgnoreCase("Anusha"))
                .collect(Collectors.toList()));
        System.out.println(names.stream().filter(name-> !name.equalsIgnoreCase("Anusha"))
                .collect(Collectors.toSet()));
        names.forEach(name-> System.out.println(name));

    }
}
