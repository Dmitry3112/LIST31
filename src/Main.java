import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static String scanner;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        while (true) {
            mainMenu(sc);
            if (scanner.equalsIgnoreCase("end")) {
                break;
            } else {
                switch (scanner) {
                    case ("1"): {
                        itemToBuy(sc, list);
                        break;
                    }
                    case ("2"): {
                        show(list);
                        break;
                    }
                    case ("3"): {
                        deleteItem(sc, list);
                        show(list);
                        break;
                    }
                    case ("4"): {
                        findItem(sc, list);
                        break;
                    }

                }
            }
        }
    }
    private static void mainMenu(Scanner sc) {
        System.out.println("Введите номер операции или end для завершения:");
        System.out.println("\t 1. Добавить предмет покупки");
        System.out.println("\t 2. Показать список покупок");
        System.out.println("\t 3. Удалить предмет покупки");
        System.out.println("\t 4. Найти предмет покупки");
        scanner = sc.nextLine();
    }
    private static void findItem(Scanner sc, ArrayList<String> list) {
        System.out.println("Какой пункт покупок хотите найти? Введите номер или название");
        scanner = sc.nextLine();
        try {
            System.out.println("Пункт покупки найден! \n" + scanner + ". " + list.get(Integer.parseInt(scanner) - 1));
        } catch (NumberFormatException e) {
            String lowerCase;
            String scanLow = scanner.toLowerCase();
            for (int i = 0; i < list.size(); i++) {
                lowerCase = list.get(i).toLowerCase();
                if (lowerCase.contains(scanLow)) {
                    System.out.println((list.indexOf(list.get(i)) + 1) + ". " + list.get(i));
                }
            }
        }
    }
    private static void deleteItem(Scanner sc, ArrayList<String> list) {
        System.out.println("Какой пункт покупок хотите удалить? Введите номер или название");
        show(list);
        scanner = sc.nextLine();
        try {
            list.remove(Integer.parseInt(scanner) - 1);
        } catch (NumberFormatException e) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equalsIgnoreCase(scanner)) {
                    list.remove(i);
                    System.out.println("Пункт покупки удален!");
                }
            }
        }
    }
    private static void itemToBuy(Scanner sc, ArrayList<String> list) {
        System.out.println("Введите предмет покупки:");
        scanner = sc.nextLine();
        list.add(scanner);
        System.out.println("Итого в списке покупок: " + list.size());
    }
    public static void show(ArrayList<String> list) {
        for (String i : list) {
            System.out.println(list.indexOf(i) + 1 + ". " + i);
        }
    }
}
