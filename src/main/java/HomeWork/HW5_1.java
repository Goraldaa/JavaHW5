package HomeWork;

import java.util.*;

public class HW5_1 {
    public static void main(String[] args) {
        Map<String, String> phonebook = new HashMap<>();
        List<String> keyArray = new ArrayList<>();
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
                commandADD(phonebook,splitCommand, keyArray);
            }else if (keyCommand.equals("GET")){
                commandGET(setKeys, phonebook,splitCommand);
            }else if (keyCommand.equals("REMOVE")){
                commandREMOVE(keyArray, phonebook,splitCommand);
            }else if (keyCommand.equals("LIST")){
                commandLIST(keyArray, phonebook);
            }else if (keyCommand.equals("EXIT")){
                flag = commandEXIT();
            }else{
                System.out.println("Введены неверные значения");
            }
        }
    }
    private static void commandADD(Map<String, String> phonebook, String[] splitCommand, List keyArr){
        if (phonebook.get(splitCommand[1]) != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(phonebook.get(splitCommand[1])).append(", ").append(splitCommand[2]);
            String result = sb.toString();
            for (int i = 0; i < keyArr.indexOf(splitCommand[1]); i++) {
                String[] phonesFitst = phonebook.get(keyArr.get(i)).split(",");
                String[] phonesSecond = result.split(",");
                if (phonesFitst.length < phonesSecond.length){
                    keyArr.remove(splitCommand[1]);
                    keyArr.add(i, splitCommand[1]);
                }

            }
            phonebook.put(splitCommand[1], result);
            System.out.println("Новый номер успешно добавлен");
        } else {
            phonebook.put(splitCommand[1], splitCommand[2]);
            keyArr.add(splitCommand[1]);
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
    private static void commandREMOVE(List<String> keyArr, Map<String, String> phonebook, String[] splitCommand){
        if (keyArr.contains(splitCommand[1])){
            phonebook.remove(splitCommand[1]);
            keyArr.remove(splitCommand[1]);
            System.out.println("Данные успешно удалены");
        }else{
            System.out.printf("Не найдена запись с фамилией \"%s\"%n", splitCommand[1]);
        }
    }
    private static void commandLIST(List<String> listKeys, Map<String, String> phonebook){
        for (String item : listKeys) {
                System.out.printf("%s: [%s]\n", item, phonebook.get(item));
        }
    }
    private static boolean commandEXIT(){
        System.out.println("До свидания");
        return false;
    }
}
