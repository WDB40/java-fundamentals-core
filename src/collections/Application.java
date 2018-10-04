package collections;

import java.util.*;

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


       /* TreeSet<MyClass> tree = new TreeSet<>(new MyComparator());

        tree.add(new MyClass("2222", "ghi"));
        tree.add(new MyClass("3333", "abc"));
        tree.add(new MyClass("1111", "def"));


        tree.forEach(myClass -> System.out.println(myClass));

*/

        Map<String, String> map = new HashMap<>();

        map.put("2222", "ghi");
        map.put("3333", "abc");
        map.put("1111", "def");

        String s1 = map.get("3333");
        String s2 = map.get("9999");
        String s3 = map.getOrDefault("9999", "Not Found");

        map.forEach((key, value) -> System.out.println(key + " | " + value));
        map.replaceAll((key, value) -> value.toUpperCase());
        map.forEach((key, value) -> System.out.println(key + " | " + value));

        SortedMap<String, String> sortedMap = new TreeMap<>();

        sortedMap.put("2222", "ghi");
        sortedMap.put("3333", "abc");
        sortedMap.put("1111", "def");
        sortedMap.put("6666", "xyz");
        sortedMap.put("4444", "mno");
        sortedMap.put("5555", "pqr");

        sortedMap.forEach((key, value) -> System.out.println(key + " | " + value));

        SortedMap<String, String> headMap = sortedMap.headMap("3333");
        sortedMap.forEach((key, value) -> System.out.println(key + " | " + value));

    }
}
