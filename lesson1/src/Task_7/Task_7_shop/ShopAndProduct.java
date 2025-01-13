package Task_7.Task_7_shop;

public class ShopAndProduct {
    public static void main(String[] args) {
        Shop shop1 = new Shop("Ярче");
        shop1.addProduct("Вафельки");
        shop1.addProduct("Прянички");
        shop1.addProduct("Мароженки");

        Shop shop2 = new Shop("Патёрочка");
        shop2.addProduct("Греча");
        shop2.addProduct("Кура");
        System.out.printf("В магазине \"%s\" продаются: %s%n", shop1.shopName, shop1.productsToString());
        System.out.printf("В магазине \"%s\" продаются: %s%n", shop2.shopName, shop2.productsToString());
        shop1.delProduct("Вафельки");
        shop1.delProduct("Мароженки");
        System.out.printf("Ой, кажется в \"%s\" остались только: %s%n", shop1.shopName, shop1.productsToString());
    }
}