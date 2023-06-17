import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Winnings {
    Queue<Toy> winnings;

    public Winnings(Queue<Toy> winnings) {
        this.winnings = winnings;
    }

    public Winnings() {
        this.winnings = new LinkedList<>();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Toy toy : winnings) {
            res.append(toy);
        }
        return res.toString();
    }

    public void get(Toys toys, Scanner iScanner) throws IOException {
        Random rnd = new Random();
        int border = 100;
        while (true) {
            System.out.println("Для выхода в главное меню введите '1', для розыгрыша введите любой другой символ: ");
            String input = iScanner.nextLine();
            if (input.equals("1")) {
                break;
            }
            int percent = 0;
            if (border == 0) {
                System.out.println("Игрушки закончились!");
                break;
            }
            int n = rnd.nextInt(border);
            for (Toy toy : toys.getList()) {
                if (n < percent + toy.getWeight()) {
                    if (toy.getQuantity() > 0) {
                        winnings.add(toy);
                        toy.setQuantity(toy.getQuantity() - 1);
                        if (toy.getQuantity() == 0) border = border - toy.getWeight();
                        break;
                    }
                } else percent = percent + toy.getWeight();
            }
        }
    }

    public void giveOut(FileWriter fw) throws IOException {
        if (winnings.size() > 0) fw.append(winnings.poll().toString());
        else System.out.println("Призы закончились!");
    }
}
