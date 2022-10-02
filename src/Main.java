import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Stepan", "Saveliev",new Address("Minsk", "Trudovaya", 25));
        Person person2 = new Person("Irina", "Zalesskaya",new Address("Homel", "Lenina", 5));
        Person person3 = new Person("Kirill", "Rozmarinov",new Address("Minsk", "Centralnaya", 10));
        ArrayList<Person> personArrayList = new ArrayList<>();
        personArrayList.add(person1);
        personArrayList.add(person2);
        personArrayList.add(person3);
        try {
        PersonIOUtil.writePersons("listPersons.txt",personArrayList);
        PersonIOUtil.printPersons(PersonIOUtil.readPersons("listPersons.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Запуск домашки 10
        System.out.println();
        System.out.println("Domashka 10.");
        PersonIOUtil.serializePerson(person2);
        System.out.println("Restored person (from person2): " + PersonIOUtil.unserializedPerson().toString());
        MyFiles myFiles = new MyFiles();
        myFiles.readDir(".\\");
        myFiles.saveList();
    }
}