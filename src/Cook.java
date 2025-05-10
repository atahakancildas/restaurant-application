class Cook extends Employee {
    private double taxrate;
    private double salary;

    public Cook(int id, String name, double salary) {
        super(id, name);
        this.taxrate = 0.18; // 18%
        this.salary = salary;
    }

    @Override
    public double calculateExpense() {
        return salary + (salary * taxrate);
    }

    @Override
    public double getSalary() {
        return salary;
    }

    public double getTaxRate() {
        return taxrate;
    }
}
