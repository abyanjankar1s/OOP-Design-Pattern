import java.util.ArrayList;
import java.util.List;

interface Store {
    void addCustomer(Customer c);
    void removeCustomer(Customer c);
    void notifyCustomers();
}

class BookStore implements Store {
    private List<Customer> customers = new ArrayList<Customer>();
    private int stockQuantity = 0;

    @Override
    public void addCustomer(Customer c){
        customers.add(c);
    }
    @Override
    public void removeCustomer(Customer c){
        customers.remove(c)
    }
    @Override
    public void notifyCustomers(){
        for(Customer customer:customers){
            customer.update(stockQuantity);
        }
    }
    public void updateQuantity(int quantity){
        this.stockQuantity = quantity;
        notifyCustomers();
    }
}

interface Customer {
    public void update(int stockQuantity);
}

class BookCustomer implements Customer {
    private int observedStockQuantity;
    private Store store;

    public BookCustomer(Store store){
        this.store = store;
        store.addCustomer(this);
    }
    @Override
    public void update(int stockQuantity){
        this.observedStockQuantity = stockQuantity;
        if (stockQuantity > 0) {
            System.out.println("Hello, The book is back in self.");
        }
    }
}

class Main {
    public static void main(String[] args) {
        Store store = new BookStore();

        Customer customer1 = new BookCustomer(store);
        Customer customer2 = new BookCustomer(store);

        System.out.println("Setting stock to 0.");
        store.updateQuantity(0);

        System.out.println("\nSetting stock to 5");
        store.updateQuantity(8);

        store.removeCustomer(customer1);

        System.out.println("\nSetting stock to 2.");
        store.updateQuantity(2);
    }
}