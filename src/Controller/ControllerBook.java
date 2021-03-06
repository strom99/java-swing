package Controller;

import Model.Author;
import Model.Books;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import Exception.*;

import javax.swing.*;

import static Controller.ControllerAuthor.Authors;
import static Controller.ControllerAuthor.getAuthorByFullName;

public class ControllerBook {

    public static ArrayList<Books> Books = new ArrayList<>();

    public static ArrayList<Books> getBooks() {
        return Books;
    }

    public static void registerBooks(Books x) throws BookException {
        if (Books.contains(x)) {
            throw new BookException("There is already a book with that ISBN");
        }

        Model.Books u = new Books( x.getTitle(),  x.getIsbn(), x.getAuthor() ,x.getPages(), x.getGender());
        Books.add(u);
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
            System.out.println("Error");
        }
        return Books.get(Books.indexOf(w));
    }

    public static List<Books> getBooksByGenre (String genre) {
        List<Books> books = new ArrayList<>();
        for(Books book : ControllerBook.getBooks()) {
            if (book.getGender().equals(genre)) {
                books.add(book);
            }
        }
        return books;
    }

    public static List<Books> getBooksByGenreAndAuthor (String genre, Author x) {
        String author = x.getName() + " " + x.getSurname() + " " + x.getSecondSurname();
        List<Books> books = new ArrayList<>();
        for(Books book: ControllerBook.getBooks()) {
            if (book.getAuthor().equals(author) && book.getGender().equals(genre)) {
                books.add(book);
            }
        }
        return books;
    }

    public static boolean changeValuesBook(Books book, Author authorx, String title, String author, String pages, String gender) {
        boolean confirm = false;
        // Modify array author
        String change = book.getAuthor();
        try {
            String[] x = author.split(" ");
            Author m = getAuthorByFullName(change);
            Author newAuthr = new Author(x[0], x[1] , x[2]);

            if(Authors.contains(newAuthr) && !authorx.equals(newAuthr)){
                throw new AuthorException("This author already exists");
            }else{
                /* separeta by parts full name*/
                m.setName(x[0]);
                m.setSurname(x[1]);
                m.setSecondSurname(x[2]);

                book.setTitle(title);
                book.setAuthor(author);
                book.setPages(pages);
                book.setGender(gender);
                confirm = true;

            }
        } catch (AuthorException | ArrayIndexOutOfBoundsException x) {
            if(x instanceof ArrayIndexOutOfBoundsException) {
                JOptionPane.showMessageDialog(null,"You need the full name");
            }
            JOptionPane.showMessageDialog(null,x.getMessage());
        }
        return confirm;
    }

    public static ArrayList searchBooksAuthor(Author x){
        String Author = x.getName() + " " + x.getSurname() + " " + x.getSecondSurname();
        ArrayList<String> books = new ArrayList<>();
        for(Books w : ControllerBook.getBooks()){
            if(w.getAuthor().equals(Author)){
                books.add(w.getIsbn());
            }
        }
        return books;
    }

    public static void deleteBook(Books x){
            Books.remove(x);

    }

    public static Books getObjetcBooks(String x) throws AuthorException {
        Model.Books bookNew = new Books(x);
        if (!Books.contains(bookNew)) {
            throw new AuthorException("The book was not found");
        }
        return Books.get(Books.indexOf(bookNew));
    }

}
