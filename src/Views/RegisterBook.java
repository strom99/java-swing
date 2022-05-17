package Views;

import Controller.ControllerAuthor;
import Controller.ControllerBook;
import Model.Author;
import Model.Books;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Exception.BookException;

import static Controller.ControllerAuthor.getAuthorByFullName;
import static Controller.ControllerBook.getAuthorBook;
import static Controller.ControllerBook.registerBooks;

public class RegisterBook extends JDialog {
    private JLabel labelISBN;
    private JTextField textFieldISBN;
    private JTextField textFieldTitle;
    private JTextField textFieldNumPages;
    private JTextField textFieldGender;
    private JButton cancelButtonRegBook;
    private JButton registerButtonBook;
    private JPanel panelRegisterBook;
    private JComboBox comboBoxRegBooks;

    public RegisterBook(JFrame parent, boolean model) {
        super(parent, model);
        setContentPane(panelRegisterBook);
        pack();
        setTitle("Register Book");
        setSize(500, 400);
        setLocationRelativeTo(null);

        for (Author u : ControllerAuthor.getAuthors()) {
            comboBoxRegBooks.addItem(u.getName() + " " + u.getSurname() + " " + u.getSecondSurname());
        }
        selectItemAuthor();

        cancelButtonRegBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        registerButtonBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
    }

    public void register() {
        if (ControllerAuthor.Authors.isEmpty()) {
            JOptionPane.showMessageDialog(this, "There are no registered authors yet", "Empty data", JOptionPane.WARNING_MESSAGE);
        } else {
            String title = textFieldTitle.getText();
            String ISBN = textFieldISBN.getText();
            String author = selectItemAuthor();
            String NumberPages = textFieldNumPages.getText();
            String gender = textFieldGender.getText();

            if (title.isEmpty() || ISBN.isEmpty() || NumberPages.isEmpty() || gender.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Fields cannot be left blank.", "Empty data", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    Books x = new Books(title, ISBN, author, NumberPages, gender);
                    registerBooks(x);
                    JOptionPane.showMessageDialog(this, "Registered book", "Registered", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (BookException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error to registration", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public String selectItemAuthor() {
        Author nameAuthor = getAuthorBook((String) comboBoxRegBooks.getSelectedItem());
        String Author = nameAuthor.getName() + " " + nameAuthor.getSurname() + " " + nameAuthor.getSecondSurname();
        return Author;
    }

}
