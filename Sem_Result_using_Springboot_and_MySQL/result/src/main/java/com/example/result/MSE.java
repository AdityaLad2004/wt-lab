package main.java.com.example.result;

@Entity
public class MSE {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    private Student student;
    private int sub1, sub2, sub3, sub4;
    // Constructors using List, Getters, Setters
}