package collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;

public class Application {

    public static void main(String[] args) {

        /*ArrayList<String> list = new ArrayList<>();

        list.add("Foo");
        list.add("Bar");

        LinkedList<String> list2 = new LinkedList<>();
        list2.add("Wes");
        list2.add("Brown");

        list2.addAll(list);

        System.out.println("Elements: " + list.size());

        for(String s: list){
            System.out.println("List: " + s);
        }

        for(String s: list2){
            System.out.println("List2: " + s);
        }

        System.out.println(list.get(0));

        */

        ArrayList<MyClass> classList = new ArrayList<>();

        MyClass v1 = new MyClass("v1", "abc");
        MyClass v2 = new MyClass("v2", "xyz");
        MyClass v3 = new MyClass("v3", "abc");

        classList.add(v1);
        classList.add(v2);
        classList.add(v3);

        Object[] objArray = classList.toArray();

        //Using a 0 because we just want to show the type of array we want
        MyClass[] classArray = classList.toArray(new MyClass[0]);

//        classList.removeIf(myClass -> myClass.getValue().equals("abc"));

//        classList.forEach(m -> System.out.println(m.getLabel()));


        TreeSet<MyClass> tree = new TreeSet<>(new MyComparator());

        tree.add(new MyClass("2222", "ghi"));
        tree.add(new MyClass("3333", "abc"));
        tree.add(new MyClass("1111", "def"));


        tree.forEach(myClass -> System.out.println(myClass));



    }
}
