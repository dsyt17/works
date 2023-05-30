package com.example.lr9;

public class Company {

    private String Name;
    private String Founders;
    private String Product;

    public Company(String Name, String Founders, String Product) {
        this.Name = Name;
        this.Founders = Founders;
        this.Product = Product;
    }

    public String getName() {
        return this.Name;
    }

    public Company() {
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFounders() {
        return this.Founders;
    }

    public void setFounders(String founders) {
        Founders = founders;
    }

    public String getProduct() {
        return this.Product;
    }

    public void setProduct(String product) {
        Product = product;
    }
}
