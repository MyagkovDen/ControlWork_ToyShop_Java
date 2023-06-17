import java.io.Serializable;
import java.util.*;

public class Toy implements Serializable {
    private int id;
    private String name;
    private int quantity;
    private int weight;

    public Toy(int id, String name, int weight, int quantity) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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
        return String.format("\nid: %d; name: %s; weight: %d; quantity: %d", id, name, weight, quantity);
        //return String.format("%s\n", name);
    }
}
