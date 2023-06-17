import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Winnings {
    Queue<Toy> winnings;

    public Winnings(Queue<Toy> winnings) {
        this.winnings = winnings;
    }

    public Winnings() {
        this.winnings = new LinkedList<Toy>();
    }

    public Queue<Toy> getWinnings() {
        return winnings;
    }

    @Override
    public String toString() {
        String res = "";
        for (Toy toy : winnings) {
            res += toy.getName().toString();
        }
        return res;
    }

    public void get(Toys toys, Scanner iScanner) {
        Random rnd = new Random();
        int border = 100;
        while (true) {
            System.out.println("Для выхода из программы введите '1', для розыгрыша введите любой другой символ: ");
            String input = iScanner.nextLine();
            if (input.equals("1")) {
                //print();
                break;
            }
            int percent = 0;
            int n = rnd.nextInt(border);
            for (Toy toy : toys.getList()) {
                if (n < percent + toy.getWeight()) {
                    if (toy.getQuantity() > 0) {
                        winnings.add(toy);
                        toy.setQuantity(toy.getQuantity() - 1);
                        if (toy.getQuantity() == 0) border = border - toy.getQuantity();
                        break;
                    }
                } else percent = percent + toy.getWeight();
            }
        }
    }

    public void print(String file) {
        try (FileWriter fw = new FileWriter(file, false)) {
            for (Toy item : winnings
            ) {
                fw.append(item.getName());
                fw.append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void giveOut() {
        winnings.poll();
    }

}
