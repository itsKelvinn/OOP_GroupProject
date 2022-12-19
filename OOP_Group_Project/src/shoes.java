public class shoes extends Products {
    static int counter = 0;
    shoes(String product_name, int product_stock) {
        super(product_name, "Shoes" , product_stock);
        counter++;
    }

    @Override
    public int product_count() {
        return counter;    
    }
    
}
