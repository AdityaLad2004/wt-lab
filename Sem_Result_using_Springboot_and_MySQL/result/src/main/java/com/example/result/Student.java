package main.java.com.example.result;

@Entity
public class Student {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String roll_no;
}