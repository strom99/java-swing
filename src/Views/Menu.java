package Views;

import Controller.ControllerAuthor;
import Controller.ControllerBook;
import Model.Author;
import Model.Books;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import static Controller.ControllerAuthor.Authors;

public class Menu extends JFrame {

    private JButton newButtonAuthors;
    private JButton modifyButtonAuthor;
    private JButton removeButtonAuthor;
    private JButton newButtonBook;
    private JButton modifyButtonBook;
    private JButton removeButtonBook;
    private JButton searchButtonBook;
    private JPanel panelMain;

    public Menu() {
        // imprecindible to run the codig
        setContentPane(panelMain);
        pack();
        setTitle("Welcome");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        Authors.add(new Author("feliu", "castello", "tomillo", "Barcelona"));
        Authors.add(new Author("Javi", "Perea", "tert", "Badalona"));
        Authors.add(new Author("Daniel", "Goleman", "were", "Badalona"));
        ControllerBook.Books.add(new Books("las mil noches", "2332132", "feliu castello tomillo", "43", "Ficcion"));
        ControllerBook.Books.add(new Books("la naranja mecanica", "22222", "Javi Perea tert", "23", "Drama"));
        ControllerBook.Books.add(new Books("metamorfosis", "33333", "Daniel Goleman were", "23", "Educativo"));

        newButtonAuthors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newAuthorActionPerformed();
            }
        });
        modifyButtonAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyAuthorActionPerformed();
            }
        });
        removeButtonAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAuthor();
            }
        });
        newButtonBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowRegisterBook();
            }
        });
        modifyButtonBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyBookWindow();
            }
        });
        removeButtonBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeBookWindow();
            }
        });
        searchButtonBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBookWindow();
            }
        });
    }

    public void modifyAuthorActionPerformed() {
        if (ControllerAuthor.getAuthors().isEmpty()) {
            JOptionPane.showMessageDialog(this, "There are no registered Authors", "Without authors", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ModifyAuthor x = new ModifyAuthor(this, true);
            x.setLocationRelativeTo(null);
            x.setVisible(true);
        }
    }

    public void newAuthorActionPerformed() {
        NewAuthor x = new NewAuthor(this, true);
        x.setLocationRelativeTo(null);
        x.setVisible(true);
    }

    public static void main(String[] args) {
        Menu menu = new Menu();
    }

    public void removeAuthor() {
        if (ControllerAuthor.getAuthors().isEmpty()) {
            JOptionPane.showMessageDialog(this, "There are no registered Authors", "Without authors", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DeleteAuthor x = new DeleteAuthor(this, true);
            x.setLocationRelativeTo(null);
            x.setVisible(true);
        }
    }

    public void windowRegisterBook() {
        if (Authors.isEmpty()) {
            JOptionPane.showMessageDialog(this, "There are no registered Authors", "Without authors", JOptionPane.INFORMATION_MESSAGE);
        } else {
            RegisterBook windowBookRegister = new RegisterBook(this, true);
            windowBookRegister.setLocationRelativeTo(null);
            windowBookRegister.setVisible(true);
        }
    }

    public void modifyBookWindow() {
        if (ControllerBook.getBooks().isEmpty()) {
            JOptionPane.showMessageDialog(this, "There are no registered bookd", "Without books", JOptionPane.INFORMATION_MESSAGE);
        } else {
            ModifyBook window = new ModifyBook(this, true);
            window.setLocationRelativeTo(null);
            window.setVisible(true);
        }
    }

    public void removeBookWindow() {
        DeleteBook window = new DeleteBook(this, true);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

    public void searchBookWindow() {
        SearchBooks window = new SearchBooks(this, true);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }

}
