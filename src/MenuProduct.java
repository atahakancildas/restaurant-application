import java.util.List;

public class MenuProduct extends Product{
    private List<Product> products;
    public MenuProduct(String name, List<Product> products) {
        super(name);
        this.products = products;
    }
    public double calculateExpense(){
        double expense = 0;
        for(Product product : products){
            expense += product.getUtilityCost();//burayı düzenle
        }
        return expense;
    }
    public double getSellingPrice(){
        double sellingPrice = 0;
        for(Product product : products){
            sellingPrice += product.getSellingPrice();
        }
        return sellingPrice;
    }
}
