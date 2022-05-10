package Controller;

import Model.Author;
import Model.Books;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

import Exception.BookException;

import static Controller.ControllerAuthor.Authors;

public class ControllerBook {

    public static ArrayList<Books> Books = new ArrayList<>();
    public static ArrayList<Books> CopyBooks = new ArrayList<>();

    public static ArrayList<Books> getBooks() {
        return Books;
    }
    public static void registerBooks(Books x) throws BookException {
        if (CopyBooks.contains(x)) {
            throw new BookException("Ya existe un libro con ese ISBN");
        }
        // transormation Strings to INT
        String title = x.getTitle();
        String Author = x.getAuthor();
        String gender = x.getGender();
        int isbn = Integer.parseInt(x.getIsbn());
        int numberPages = Integer.parseInt(x.getPages());

        Model.Books u = new Books(title, isbn, Author, numberPages, gender);
        CopyBooks.add(x);
        Books.add(u);

    }

    public static Author getAuthorBook(String x) {
        String[] parts = x.split(" ");
        Author author = new Author(parts[0], parts[1], parts[2]);
        return Authors.get(Authors.indexOf(author));
    }

}
