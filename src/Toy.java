import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Toy {
    private int id;
    private String name;
    //private int quantity;
    private int weight;

    public Toy(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

/*    public int getQuantity() {
        return quantity;
    }*/

    public int getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

/*
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
*/

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, weight);
    }

    @Override
    public boolean equals(Object obj) {
        Toy t = (Toy) obj;
        return id == t.id && name.equals(t.name);
    }

    @Override
    public String toString() {
        return String.format("\n%d %s %d", id, name, weight);
    }

    public static List<Toy> put() {
        List<Toy> Toys = new ArrayList<>();
        System.out.println("Введите id, 'вес' и название игрушки или введите 'exit':");
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            String[] input = iScanner.nextLine().split(" ");
            if (input[0].equals("exit")) break;
            Toys.add(new Toy(Integer.parseInt(input[0]), input[2], Integer.parseInt(input[1])));
        }
        //iScanner.close();
        return Toys;
    }

    public static void get(List<Toy> toys) {
        Random rnd = new Random();
        Scanner iScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Для выхода из программы введите '1', для розыгрыша введите любой другой " +
                    "символ для розыгрыша: ");
            String input = iScanner.nextLine();
            if (input.equals("1")) break;
            int percent = 0;
            try (FileWriter fw = new FileWriter("file.txt", false)) {
                int n = rnd.nextInt(100);
                for (int i = 0; i < toys.size(); i++) {
                    if (n < percent + toys.get(i).getWeight()) {
                        System.out.println(toys.get(i).getName());
                        fw.append(toys.get(i).getName());
                        fw.append("\n");
                        break;
                    } else percent = toys.get(i).getWeight();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        iScanner.close();
    }
}
