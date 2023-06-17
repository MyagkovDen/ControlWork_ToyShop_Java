import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Toys toys = new Toys();
        Winnings winnings = new Winnings();
        start(toys, winnings);

    }

    public static void start(Toys toys, Winnings winnings) {
        Scanner iScanner = new Scanner(System.in);
        try (FileWriter fw = new FileWriter("file.txt", false)) {
            while (true) {
                System.out.println("\nДля добавления игрушки нажмите '1'" +
                        "\nДля создания списка призов (розыгрыша) нажмите '2'" +
                        "\nДля выдачи приза нажмите '3'" +
                        "\nДля выхода из программы нажмите  '4'");
                String input = iScanner.nextLine();
                switch (input) {
                    case "1" -> toys.put(iScanner);
                    case "2" -> winnings.get(toys, iScanner);
                    case "3" -> winnings.giveOut(fw);
                    case "4" -> {
                        iScanner.close();
                        fw.flush();
                        return;
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}