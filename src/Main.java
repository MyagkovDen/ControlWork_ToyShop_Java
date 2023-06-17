import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Toys toys = new Toys();
        Winnings winnings = new Winnings();
        String file = "note.txt";
        start(toys, winnings, file);

    }

    public static void start(Toys toys, Winnings winnings, String file) {
        while (true) {
            System.out.println("\nДля создания списка игрушек нажмите '1'" +
                    "\nДля создания списка призов (розыгрыша) нажмите '2'" +
                    "\nДля выдачи приза нажмите '3'" +
                    "\nДля записи списка призов нажмите '4" +
                    "\nДля выхода из программы нажмите  '5'");
            Scanner iScanner = new Scanner(System.in);
            String input = iScanner.nextLine();
            switch (input) {
                case "1":   toys.put(iScanner);
                            break;
                case "2":   winnings.get(toys, iScanner);
                            break;
                case "3":   winnings.giveOut();
                            break;
                case "4":   winnings.print(file);
                            break;
                case "5":   iScanner.close();
                            return;
            }
        }
    }
}