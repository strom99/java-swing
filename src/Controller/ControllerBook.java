package Controller;

import Model.Author;
import Model.Books;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Scanner;

import Exception.*;

import static Controller.ControllerAuthor.Authors;
import static Controller.ControllerAuthor.getAuthorByFullName;
import static MethodsGlobals.methods.separateFullNameByName;

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
        if(!CopyBooks.contains(w)){
            System.out.println("error");
        }
        return CopyBooks.get(CopyBooks.indexOf(w));
    }

    public static void changeValuesBook(Books book , String title ,String author, String pages,String gender){
        // modify books array original
        int pagesTrasn = Integer.parseInt(pages);

        // Modify array author
        String change = book.getAuthor();
        try{
            Author m = getAuthorByFullName(change);/*
            String name = (String) separateFullNameByName(change);*/
            String[] x = author.split(" ");
            m.setName(x[0]);
            m.setSurname(x[1]);
            m.setSecondSurname(x[2]);

        }catch (AuthorException x){
//JoptionPaNW        }
        System.out.println(book.getAuthor());
        System.out.println("new"+ author);
        book.setTitle(title);
        book.setAuthor(author);
        book.setNumberOfPages(pagesTrasn);
        book.setGender(gender);

        System.out.println(book);

        // modify CopyBooks array
    }

}
