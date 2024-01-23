package com.behavioral.iterator_pattern;

public class IteratorPatternDemo {
    public static void main(String[] args) {
        Container container = new CollectionofNames();

        for(Iterator iter = container.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}
