package serialization;

import java.io.*;

public class App {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Dog dog = new Dog();
        dog.setName("gona");
        dog.caste="reddy";


        Cat cat = new Cat();
        cat.race="geethalpilli";

        FileOutputStream fileOutputStream = new FileOutputStream("dog.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(dog);
        objectOutputStream.writeObject(cat);
        //FileOutputStream fileOutputStream1 = new FileOutputStream("cat.txt");
       // ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream1);

       // objectOutputStream1.writeObject(cat);



/*

        FileInputStream fileInputStream1 = new FileInputStream("cat.txt");
        ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream1);

        Cat dcat = (Cat) objectInputStream1.readObject();
*/

        FileInputStream fileInputStream = new FileInputStream("dog.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Dog d1 = (Dog) objectInputStream.readObject();
        Cat dcat = (Cat) objectInputStream.readObject();
        objectInputStream.readObject();

        System.out.println(d1.caste);
        System.out.println(dcat.getName());



    }
}
