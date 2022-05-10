package MethodsGlobals;

import Exception.BookException;
public class methods {
    public static void controlSpaceBlank(String letter) throws BookException {
        if (letter.matches("[A-Za-z][\\S][\\\\d]")) {
            throw new BookException("hay de todo");
        }
    }
}
