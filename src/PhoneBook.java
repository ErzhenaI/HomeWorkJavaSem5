import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
//    Реализуйте структуру телефонной книги с помощью HashMap.
//    Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
//    их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по
//    убыванию числа телефонов

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<String, ArrayList<String>>();

        addContact(phoneBook, "Jonny", "11111");
        addContact(phoneBook, "Anna", "22222");
        addContact(phoneBook, "Samuel", "33333");
        addContact(phoneBook, "Jonny", "44444");
        addContact(phoneBook, "Anna", "55555");
        addContact(phoneBook, "Jonny", "66666");

        printPhoneBook(phoneBook);
    }

    public static void addContact(HashMap<String, ArrayList<String>> phoneBook, String firstName, String phoneNum) {
        if (phoneBook.containsKey(firstName)) {
            phoneBook.get(firstName).add(phoneNum);
        } else {
            ArrayList<String> phoneNums = new ArrayList<String>();
            phoneNums.add(phoneNum);
            phoneBook.put(firstName, phoneNums);
        }
    }

    public static void printPhoneBook(HashMap<String, ArrayList<String>> phoneBook) {
        HashMap<Integer, ArrayList<String>> sortedPhoneBook = new HashMap<Integer, ArrayList<String>>();

        for (String name : phoneBook.keySet()) {
            int numOfPhoneNums = phoneBook.get(name).size();

            if (sortedPhoneBook.containsKey(numOfPhoneNums)) {
                sortedPhoneBook.get(numOfPhoneNums).add(name);
            } else {
                ArrayList<String> names = new ArrayList<String>();
                names.add(name);
                sortedPhoneBook.put(numOfPhoneNums, names);
            }
        }

        List<Integer> sortedKeys = new ArrayList<Integer>(sortedPhoneBook.keySet());
        Collections.sort(sortedKeys, Collections.reverseOrder());

        for (int key : sortedKeys) {
            ArrayList<String> firstNames = sortedPhoneBook.get(key);
            for (String firstName : firstNames) {
                System.out.println(firstName + " has " + key + " phonenumbers");
            }
        }
    }
}