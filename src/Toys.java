import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Toys implements Serializable{
    private List<Toy> toys;

    public Toys(List<Toy> toys) {
        this.toys = toys;
    }

    public Toys() {
        this.toys = new ArrayList<>();
    }

    public List<Toy> getList() {
        return toys;
    }

    public void put(Scanner iScanner) {
        System.out.println("Введите через пробел id, название, удельный вес и количество игрушки или введите 'стоп' " +
                "для выхода в главное меню:");
        while (true) {
            String[] input = iScanner.nextLine().split(" ");
            if (input[0].equals("стоп")) break;
            try {
                toys.add(new Toy(Integer.parseInt(input[0]), input[1], Integer.parseInt(input[2]),
                        Integer.parseInt(input[3])));
            } catch (Exception e) {
                System.out.println("Ошибка ввода!");
            }
        }
    }

    public void saveData() throws IOException {
        FileOutputStream fos = new FileOutputStream("list.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }

    public Toys loadData() throws IOException {
        FileInputStream fis = new FileInputStream("list.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Toys toys = null;
        try {
            toys = (Toys) ois.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("Файл не найден!");;
        }
        ois.close();
        return toys;
    }
}
