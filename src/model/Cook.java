package model;

public class Cook extends Employee {
    private double taxRate;
    private double salary;

    public Cook(int id, String name, double salary) {
        super(id, name);

        this.taxRate = 0.18;
        this.salary = salary;
    }

    @Override
    public double calculateExpense() {
        return salary + (salary * taxRate);
    }

    public double getSalary() {
      return salary;
    }

    public double getTaxRate() {
        return taxRate;
    }
}
