public class pants extends Products{
    static int counter = 0;
    
    pants(String product_name, int product_stock) {
        super(product_name, "Pants", product_stock);
        counter++;
    }

    @Override
    public int product_count() {
        return counter;
    }
    
}
