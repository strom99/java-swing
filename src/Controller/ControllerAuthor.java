package Controller;

import Model.Author;
import Exception.AuthorException;
import Model.Books;

import javax.swing.*;
import java.util.ArrayList;

import static Controller.ControllerBook.getBookByIsbn;

public class ControllerAuthor {
    public static ArrayList<Author> Authors = new ArrayList<>();

    public static void register(Author x) throws AuthorException {
        if (Authors.contains(x)) {
            throw new AuthorException("Ya existe un autor con ese nombre");
        }
        Authors.add(x);
    }

    public static ArrayList<Author> getAuthors() {
        return Authors;
    }

    public static Author getAuthorByFullName(String x) throws AuthorException {
        String[] parts = x.split(" ");
        Author author = new Author(parts[0], parts[1], parts[2]);
        if (!Authors.contains(author)) {
            throw new AuthorException("No existe un autor con ese nombre");
        }
        return Authors.get(Authors.indexOf(author));
    }

    public static void modifyAuthor(Author x, String newName, String newSurname , String newSecondSurname, String newCountry) throws AuthorException  {

        Author check = new Author(newName,newSurname,newSecondSurname);
        // delete books author
        if(Authors.contains(check) && !x.equals(check)){
            throw new AuthorException("Ya existe ese autor");
        }else{
            ArrayList<String> books = ControllerBook.searchBooksAuthor(x);
            String Author = newName+" "+newSurname+" "+newSecondSurname;
            for (String d : books) {
                Books s = getBookByIsbn(d);
                s.setAuthor(Author);
            }

            // modify author
            x.setName(newName);
            x.setSurname(newSurname);
            x.setSecondSurname(newSecondSurname);
            x.setCountry(newCountry);
        }

    }

    public static void deleteAuthor(Author x) throws AuthorException {
        if(!Authors.contains(x)){
            throw new AuthorException("No se pudo eliminar");
        }else{
            Authors.remove(x);
        }
    }

    /*public static boolean checkModify(Author x) throws AuthorException{
        if(Authors.contains(x)){
            throw new AuthorException("El nombre corresponde a otro author");
        }
        return true;
    }*/

}
