package Task_7.Task_7_shop;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public String shopName;
    private List<Product> products;

    public Shop(String shopName) {
        this.shopName = shopName;
        this.products = new ArrayList<>();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void addProduct(String productName) {
        Product product = new Product(productName);
        products.add(product);
    }

    public void delProduct(String productName) {
        products.removeIf(product -> product.getProductName().equals(productName));
    }

    public static class Product {
        private String productName;

        public Product(String productName) {
            this.productName = productName;
        }

        public String getProductName() {
            return productName;
        }

        public void setProductName(String productName) {
            this.productName = productName;
        }
    }

    public String productsToString() {
        StringBuilder result = new StringBuilder();
        for (Shop.Product product : this.getProducts()) {
            result.append(product.getProductName()).append(", ");
        }
        if (!result.isEmpty()) {
            result.setLength(result.length() - 2);  // Убираем последнюю запятую и пробел
        }
        return result.toString();
    }
}