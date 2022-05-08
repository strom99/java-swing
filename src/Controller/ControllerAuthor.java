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
        Author author = new Author(parts[0], parts[1], parts[2], parts[3]);
        if (!Authors.contains(author)) {
            throw new AuthorException("No existe un autor con ese nombre");
        }
        return Authors.get(Authors.indexOf(author));
    }

}
