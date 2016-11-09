package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution solution = new Solution();
        Solution.B be = solution.new B("A");
        ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("/home/lion/java/test/your_file_name.tmp"));
        ous.writeObject(be);
        ObjectInputStream ous1 = new ObjectInputStream(new FileInputStream("/home/lion/java/test/your_file_name.tmp"));
        Solution.B be1 = (B) ous1.readObject();
        System.out.println(be.name);
        System.out.println(be1.name);
        ous.close();
        ous1.close();
    }

    public static class A {
        public A (){}
        transient protected String name = "A";
        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {
        private void writeObject (ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            this.name = (String)in.readObject();
        }
        public B(String name) {
            super(name);
            this.name += name;
        }
    }
}
