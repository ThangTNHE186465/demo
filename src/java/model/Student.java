package model;

public class Student {
    int id;
    String name, add;
    double score;

    public Student() {
    }

    public Student(int id, String name, String add, double score) {
        this.id = id;
        this.name = name;
        this.add = add;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
