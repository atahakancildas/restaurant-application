package model;

public abstract class Employee implements Expense {
    protected int id;
    protected String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract double calculateExpense();

    @Override
    public String toString() {
        return "Employee " + (id + 1) + ": " + name;
    }
}

