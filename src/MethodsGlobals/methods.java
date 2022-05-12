package MethodsGlobals;

import Exception.BookException;
import Model.Books;

public class methods {
    public static void controlSpaceBlank(String letter) throws BookException {
        if (letter.matches("[A-Za-z][\\S][\\\\d]")) {
            throw new BookException("hay de todo");
        }
    }

    // separate full name
    public static Object separateFullNameByName(String x){
        String[] parts = x.split(" ");
        Books w = new Books(parts[0]);
        return x;
    }
}
