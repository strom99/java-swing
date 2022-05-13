import Controller.ControllerAuthor;
import Controller.ControllerBook;
import Model.Author;
import Model.Books;

public class borrador {


    public static void main(String[] args) {

        // check books
        System.out.println("--------------- book---------------");
        for (Books X : ControllerBook.getBooks()) {
            System.out.println(X);
        }

        System.out.println("--------------- authors---------------");
        for (Author X : ControllerAuthor.getAuthors()) {
            System.out.println(X);
        }

    }
}
