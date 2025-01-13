package src.Task_7.Task_7_book;

public class BookAndAuthors {
    public static void main(String[] args) {
        Book book1 = new Book("Нейромант");
        book1.addAuthor("Уильям Гибсон");

        Book book2 = new Book("Мечтают ли андроиды об электроовцах?");
        book2.addAuthor("Филип Дик");

        Book book3 = new Book("Схизматрица");
        book3.addAuthor("Брюс Стерлинг");

        Book book4 = new Book("Машина различий");
        book4.addAuthor("Брюс Стерлинг");
        book4.addAuthor("Уильям Гибсон");
        System.out.printf("Автор(ы) книги \"%s\": %s%n", book1.bookTitle, book1.authorsToString());
        System.out.printf("Автор(ы) книги \"%s\": %s%n", book2.bookTitle, book2.authorsToString());
        System.out.printf("Автор(ы) книги \"%s\": %s%n", book3.bookTitle, book3.authorsToString());
        System.out.printf("Автор(ы) книги \"%s\": %s%n", book4.bookTitle, book4.authorsToString());
        book4.delAuthor("Брюс Стерлинг");
        System.out.printf("У книги \"%s\" остался только: %s%n", book4.bookTitle, book4.authorsToString());
    }
}