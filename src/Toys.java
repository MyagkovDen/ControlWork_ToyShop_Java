import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Toys {
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

    public List<Toy> put(Scanner iScanner) {
        System.out.println("Введите id, название, удельный вес и количество игрушки или введите 'exit':");
        while (true) {
            String[] input = iScanner.nextLine().split(" ");
            if (input[0].equals("exit")) break;
            toys.add(new Toy(Integer.parseInt(input[0]), input[1], Integer.parseInt(input[2]),
                    Integer.parseInt(input[3])));
        }
        return toys;
    }
}
