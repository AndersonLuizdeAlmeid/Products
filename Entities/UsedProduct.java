package Entities;

import java.sql.Date;
import java.time.LocalDate;

public class UsedProduct extends Product {

    private LocalDate manufacture;

    public LocalDate getManufacture() {
        return manufacture;
    }

    public void setManufacture(LocalDate manufacture) {
        this.manufacture = manufacture;
    }

    public UsedProduct(String name, Double price, LocalDate manufacture) {
        super(name, price);
        this.manufacture = manufacture;
    } 
    
    @Override
    public String priceTag(){
        StringBuilder sb = new StringBuilder();
        sb.append(getName() + "(used)");
        sb.append(" $" + getPrice());
        sb.append("( Manufacture date: " + manufacture +")");
        return sb.toString();
    }
}
