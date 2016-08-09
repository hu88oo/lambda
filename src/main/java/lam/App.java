package lam;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        String str="1,2,3,4,5,6,8,9";

        String[] strarr=str.split(",");
        //List<Integer> l= Arrays.asList(strarr);
        Integer[] ints=new Integer[]{4,5,6};
        int c=4;
        boolean result1=(Arrays.asList(ints)).contains(c);
            int e=2;



        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("tom", 11));
        persons.add(new Person("tom", 13));
        persons.add(new Person("tom2", 26));
        persons.add(new Person("tom3", 18));
        persons.add(new Person("tom4", 19));
        List list=new ArrayList<>();
        persons.stream().forEach(p->list.add(p.getAge()));
        long count = persons.stream().filter(p -> p.getAge() > 17).count();
        persons.stream().forEach(p -> System.out.println(p.toString()));
        persons.stream().forEach(System.out::println);
        Map<String, List<Person>> map = persons.stream().collect(Collectors.groupingBy(Person::getName));
        int max = persons.stream().mapToInt(p -> p.getAge()).max().getAsInt();
        int result = persons.stream().map(p -> p.getAge()).reduce(0, (a, b) -> a + b);
        List<Person> personList = persons.stream().sorted((p1, p2) -> Integer.valueOf(p2.getAge()).compareTo(Integer.valueOf(p1.getAge()))).collect(Collectors.toList());

        int pagesize = 2;
        int pageNum = 2;
        List<Person> pageList = persons.stream().skip(pagesize * (pageNum - 1)).limit(pagesize).collect(Collectors.toList());
        List<Person> personList1 = persons.stream().sorted(Comparator.comparing(Person::getAge).reversed()).collect(Collectors.toList());
        System.out.println(max);
    }
}


class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + ":" + String.valueOf(this.getAge());
    }
//    @Override
//    public int compareTo(){

//}
}