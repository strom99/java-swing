package Controller;

import Model.Author;
import Model.Books;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

import Exception.*;

import javax.swing.*;

import static Controller.ControllerAuthor.Authors;
import static Controller.ControllerAuthor.getAuthorByFullName;
import static MethodsGlobals.methods.separateFullNameByName;

public class ControllerBook {

    public static ArrayList<Books> Books = new ArrayList<>();

    public static ArrayList<Books> getBooks() {
        return Books;
    }

    public static void registerBooks(Books x) throws BookException {
        if (Books.contains(x)) {
            throw new BookException("Ya existe un libro con ese ISBN");
        }

        Model.Books u = new Books( x.getTitle(),  x.getIsbn(), x.getAuthor() ,x.getPages(), x.getGender());
        Books.add(u);
        System.out.println(u);

    }

    public static Author getAuthorBook(String x) {
        String[] parts = x.split(" ");
        Author author = new Author(parts[0], parts[1], parts[2]);
        return Authors.get(Authors.indexOf(author));
    }

    public static Books getBookByIsbn(String x) {
        String[] parts = x.split("-");
        Books w = new Books(parts[0]);
        if (!Books.contains(w)) {
            System.out.println("error");
        }
        return Books.get(Books.indexOf(w));
    }

    public static void changeValuesBook(Books book, String title, String author, String pages, String gender) {
        // modify books array original

        // Modify array author
        String change = book.getAuthor();
        try {
            Author m = getAuthorByFullName(change);/*
            String name = (String) separateFullNameByName(change);*/
            String[] x = author.split(" ");
            m.setName(x[0]);
            m.setSurname(x[1]);
            m.setSecondSurname(x[2]);


        } catch (AuthorException x) {
            JOptionPane.showMessageDialog(null,x.getMessage());
        }
        System.out.println(book.getAuthor());
        System.out.println("new" + author);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPages(pages);
        book.setGender(gender);
        System.out.println(book);

    }

    public static ArrayList searchBooksAuthor(Author x){
        String Author = x.getName() + " " + x.getSurname() + " " + x.getSecondSurname();
        ArrayList<String> books = new ArrayList<>();
        System.out.println(Author+"A");
        System.out.println(x.getName());
        for(Books w : ControllerBook.getBooks()){
            if(w.getAuthor().equals(Author)){
                books.add(w.getIsbn());
                System.out.println(w.getAuthor()+"ddd");
                System.out.println(Author+"ss");
            }
        }
        return books;
    }

    public static void deleteBook(Books x){
            Books.remove(x);

    }


}
