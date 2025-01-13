package src.Task_7.Task_7_book;

import java.util.ArrayList;
import java.util.List;

public class Book {
    public String bookTitle;
    private List<Author> authors;

    public Book(String bookTitle) {
        this.bookTitle = bookTitle;
        this.authors = new ArrayList<>();
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(String name) {
        Author author = new Author(name);
        authors.add(author);
    }

    public void delAuthor(String name) {
        authors.removeIf(author -> author.getName().equals(name));
    }

    public String authorsToString() {
        StringBuilder result = new StringBuilder();
        for (Book.Author author : this.getAuthors()) {
            result.append(author.getName()).append(", ");
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 2);  // Убираем последнюю запятую и пробел
        }
        return result.toString();
    }

    public static class Author {
        private String name;

        public Author(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}