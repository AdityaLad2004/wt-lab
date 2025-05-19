package main.java.com.example.groceryauth;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
