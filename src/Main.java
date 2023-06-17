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
                System.out.println("\nДля создания списка игрушек или добавления игрушки в список " +
                        "нажмите '1'" +
                        "\nДля изменения 'веса' игрушки нажмите '2'" +
                        "\nДля загрузки списка игрушек нажмите '3'" +
                        "\nДля сохранения списка игрушек нажмите '4'" +
                        "\nДля создания списка призов (розыгрыша) нажмите '5'" +
                        "\nДля выдачи приза нажмите '6'" +
                        "\nДля выхода из программы нажмите  '7'");
                String input = iScanner.nextLine();
                switch (input) {
                    case "1" -> toys.put(iScanner);
                    case "2" -> toys.changeWeight(iScanner);
                    case "3" -> toys = toys.loadData();
                    case "4" -> toys.saveData();
                    case "5" -> winnings.get(toys, iScanner);
                    case "6" -> winnings.giveOut(fw);
                    case "7" -> {
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