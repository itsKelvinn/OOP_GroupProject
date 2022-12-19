import java.util.ArrayList;

public abstract class Products {
    // Datas
    private ArrayList<String> historyMassage = new ArrayList<>();
    private ArrayList<Integer> historyQuatity = new ArrayList<>();
    private String product_name;
    private String product_type;
    private int product_stock;

    Products(String product_name ,String product_type ,int product_stock){
        this.product_name = product_name;
        this.product_type = product_type;
        this.product_stock = product_stock;
    }

    public String getProduct_name() {
        return product_name;
    }

    public int getProduct_stock() {
        return product_stock;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void minProduct_stock(int stock,String massage){
        historyMassage.add(massage);
        historyQuatity.add(-stock);
        this.product_stock = this.product_stock - stock;
    }

    public void plusProduct_stock(int stock, String massage){
        historyMassage.add(massage);
        historyQuatity.add(stock);
        this.product_stock = this.product_stock + stock;
    }

    public abstract int product_count();
}
