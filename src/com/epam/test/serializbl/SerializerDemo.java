package com.epam.test.serializbl;

public class SerializerDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Joe Satriani", 57);

        String s = Serializer.dumps(p1);

        System.out.println(s);

        Person p2 = (Person) Serializer.loads(s);

        System.out.println(p2);
        System.out.println(p2.getName());

    }
}
