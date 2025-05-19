package main.java.com.example.result;

public class ResultDTO {
    private String name;
    private String roll_no;
    private List<Integer> mse;
    private List<Integer> ese;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll_no() {
        return roll_no;
    }

    public void setRoll_no(String roll_no) {
        this.roll_no = roll_no;
    }

    public List<Integer> getMse() {
        return mse;
    }

    public void setMse(List<Integer> mse) {
        this.mse = mse;
    }

    public List<Integer> getEse() {
        return ese;
    }

    public void setEse(List<Integer> ese) {
        this.ese = ese;
    }
}
