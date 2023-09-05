import java.io.FileWriter;
import java.util.Scanner;

public class DataRequest {

    private String firstName;
    private String middleName;
    private String lastName;
    private long numberPhone;
    private final Scanner scan = new Scanner(System.in);

    // Методы для присваивания значений полям
    private void EnterFirstName() {
        System.out.println("Enter first name:");
        firstName = scan.nextLine();
        if (firstName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterMiddleName() {
        System.out.println("Enter middle name");
        middleName = scan.nextLine();
        if (middleName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterLastName() {
        System.out.println("Enter last name:");
        lastName = scan.nextLine();
        if (lastName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterNumberPhone() {
        try {
            System.out.println("Enter number phone:");
            String number = scan.nextLine();
            if (number.equals("")) {
                throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
            }
            numberPhone = Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Не верный формат, попробуйте снова!");
        }
    }

    // Метод для вывода в консоль получившихля значений
    private void OutPutData() {
        System.out.println("\nFirst name \t- \t" + firstName + "\n" + "Middle name \t- \t" + middleName + "\n"
                + "Last name \t- \t" + lastName + "\n" + "Number phone \t- \t" + numberPhone);
    }

    // Метод для соединения всех методов в один
    private void DataEnter() {
        EnterFirstName();
        EnterMiddleName();
        EnterLastName();
        EnterNumberPhone();
        OutPutData();
    }

    // Метод для сохранения данных в файл
    public void SaveDataEnter() {

        DataEnter();
        String file = "data/" + lastName + ".txt";
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("<" + firstName + "> " + "<" + middleName + "> " + "<" + lastName + "> " + "<" + numberPhone
                    + "> \n");
        } catch (Exception e) {
            System.out.println("Чтото пошло не так!");
        }
    }

    // Геттеры для полей

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public long getNumberPhone() {
        return numberPhone;
    }
}
