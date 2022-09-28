import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class PersonIOUtil {
    static void writePersons (String fileName, ArrayList<Person> personArrayList){
        try (FileWriter writer = new FileWriter(fileName)){
            for (int i = 0; i < personArrayList.size();i++){
                writer.write(personArrayList.get(i).toString() + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static ArrayList<Person> readPersons (String filename) throws EmptySourceFileException{
        ArrayList<Person> personArrayList = new ArrayList<>();
        String s = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            if ((s = reader.readLine())==null) {
                throw new EmptySourceFileException("Exception! Empty file, or file not exists");
            } else {
                personArrayList.add(restorePerson(s));
                while ((s = reader.readLine()) != null){
                    personArrayList.add(restorePerson(s));
                }
            }
        }
        catch (EmptySourceFileException e){
            System.out.println(e.getMessage());
        }
        catch (FileNotFoundException e){
            throw new EmptySourceFileException("Exception! Empty file, or file not exists");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return personArrayList;
    }
    static Person restorePerson (String s){
        String[] strPerson = s.split(" ");
        Person restoredPerson = new Person(strPerson[0],strPerson[1],new Address(strPerson[2],strPerson[3],Integer.parseInt(strPerson[4])));
        return restoredPerson;
    }
    static void printPersons (ArrayList<Person> personArrayList) {
        for (Person person: personArrayList) {
            System.out.println(person.toString());
        }
    }

}
