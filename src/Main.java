import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Toy> toys = Toy.put();
        System.out.println(toys);

        Toy.get(toys);
    }


}