package Controller;

import Model.Author;
import Exception.AuthorException;
import java.util.ArrayList;

public class ControllerAuthor {
    private static ArrayList<Author> Authors = new ArrayList<>();

    public static void register(Author x) throws AuthorException {
        if (Authors.contains(x)) {
            throw new AuthorException("Ya existe un autor con ese nombre");
        }
        Authors.add(x);
    }

    public static ArrayList<Author> getAuhtors() {
        return Authors;
    }

}
