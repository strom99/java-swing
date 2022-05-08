package Controller;

import Model.Author;
import Exception.AuthorException;

import javax.swing.*;
import java.util.ArrayList;

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
        x.setName(newName);
        x.setSurname(newSurname);
        x.setSecondSurname(newSecondSurname);
        x.setCountry(newCountry);
    }

    public static void deleteAuthor(Author x) throws AuthorException{
        if(Authors.contains(x)){
            Authors.remove(x);
        }else{
            throw new AuthorException("no se elimino");
        }
    }

    /*public static boolean checkModify(Author x) throws AuthorException{
        if(Authors.contains(x)){
            throw new AuthorException("El nombre corresponde a otro author");
        }
        return true;
    }*/

}
