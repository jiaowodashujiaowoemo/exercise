package javaFoundation;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @Description 当集合里面的对象属性被修改后，再调用remove（）方法时不起作用
 * 需要重写hashcode方法和equals方法，否则还是之前的结果
 * @Author ChenXiang
 * @Date 2019/02/24,21:35
 */
public class SetRemove {
    public static void main(String[] args) {
        Set<Person> set = new HashSet<Person>();
        Person p1 = new Person("唐僧", "pwd1", 25);
        Person p2 = new Person("孙悟空", "pwd2", 26);
        Person p3 = new Person("猪八戒", "pwd3", 27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("总共有:" + set.size() + " 个元素!"); //结果：总共有:3 个元素!
        p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变

        set.remove(p3); //此时remove不掉，造成内存泄漏

        set.add(p3); //重新添加，居然添加成功
        System.out.println("总共有:" + set.size() + " 个元素!"); //结果：总共有:4 个元素!
        for (Person person : set) {
            System.out.println(person);
        }
    }
}

class Person {
    String name;
    String pwd;
    int age;

    public Person(String name, String pwd, int age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(pwd, person.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pwd, age);
    }
}
