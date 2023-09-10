package HomeWork;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HW5_1 {
    public static void main(String[] args) {
        Map<String, String> phonebook = new HashMap<>();
        System.out.println("Спиков команд:\n" +
                "1. ADD - добавить в справочник новое значение\n" +
                "2. GET - получить список всех номеров по фамилии\n" +
                "3. REMOVE - удалить все номера по фамилии\n" +
                "4. LIST - Посмотреть все записи\n" +
                "5. EXIT - Завершить программу");
        boolean flag = true;
        while (flag) {
            System.out.println("Введите команду:");
            Scanner sc = new Scanner(System.in);
            String command = sc.nextLine();
            String[] splitCommand = command.split(" ", 3);
            String keyCommand = splitCommand[0];
            Set<String> setKeys = phonebook.keySet();
            if (splitCommand[0].equals("ADD")){
                commandADD(phonebook,splitCommand);
            }else if (keyCommand.equals("GET")){
                commandGET(setKeys, phonebook,splitCommand);
            }else if (keyCommand.equals("REMOVE")){
                commandREMOVE(setKeys, phonebook,splitCommand);
            }else if (keyCommand.equals("LIST")){
                commandLIST(setKeys, phonebook);
            }else if (keyCommand.equals("EXIT")){
                flag = commandEXIT();
            }else{
                System.out.println("Введены неверные значения");
            }
        }
    }
    private static void commandADD(Map<String, String> phonebook, String[] splitCommand){
        if (phonebook.get(splitCommand[1]) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(phonebook.get(splitCommand[1])).append(", ").append(splitCommand[2]);
            phonebook.put(splitCommand[1], sb.toString());
            System.out.println("Новый номер успешно добавлен");
        } else {
            phonebook.put(splitCommand[1], splitCommand[2]);
            System.out.println("Данные успешно добавлены");
        }
    }
    private static void commandGET(Set<String> setKeys, Map<String, String> phonebook, String[] splitCommand){
        if(setKeys.contains(splitCommand[1])){
            System.out.printf("[%s]%n", phonebook.get(splitCommand[1]));
        }else {
            System.out.printf( "Не найдена запись с фамилией \"%s\"%n", splitCommand[1]);
        }
    }
    private static void commandREMOVE(Set<String> setKeys, Map<String, String> phonebook, String[] splitCommand){
        if (setKeys.contains(splitCommand[1])){
            phonebook.remove(splitCommand[1]);
            System.out.println("Данные успешно удалены");
        }else{
            System.out.printf("Не найдена запись с фамилией \"%s\"%n", splitCommand[1]);
        }
    }
    private static void commandLIST(Set<String> setKeys, Map<String, String> phonebook){
        for (String item : setKeys) {
            System.out.printf("%s: [%s]\n", item, phonebook.get(item));
        }
    }
    private static boolean commandEXIT(){
        System.out.println("До свидания");
        return false;
    }
}
