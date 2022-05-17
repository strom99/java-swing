package Views;

import Controller.ControllerBook;
import Model.Author;
import Model.Books;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;

import static Controller.ControllerBook.*;

public class ModifyBook extends JDialog {

    Author authorSelectionated;
    Books bookSelectionated;

    private JComboBox comboBoxModBooks;
    private JButton buttonSelectModifyBook;
    private JButton buttonCancel;
    private JButton buttonCheckEdition;
    private JTextField textFieldTitle;
    private JTextField textFieldISBN;
    private JTextField textFieldNuPages;
    private JTextField textFieldGender;
    private JPanel panelModify;
    private JTextField textFieldAuthorName;

    public ModifyBook(JFrame parent, boolean modal) {
        super(parent, modal);
        pack();
        setTitle("Modify Book");
        setContentPane(panelModify);
        setSize(600, 500);
        // desactive edition text field ISBN
        textFieldISBN.setEnabled(false);


        for (Books u : ControllerBook.Books) {
            comboBoxModBooks.addItem(u.getIsbn() + "-" + u.getTitle());
        }
        selectItemBook();

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonSelectModifyBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectItemBook();
            }
        });
        buttonCheckEdition.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ModifyBook();
            }
        });
    }

    public void selectItemBook() {
        bookSelectionated = getBookByIsbn((String) comboBoxModBooks.getSelectedItem());
        textFieldTitle.setText(bookSelectionated.getTitle());
        textFieldAuthorName.setText(bookSelectionated.getAuthor());
        textFieldISBN.setText(bookSelectionated.getIsbn());
        textFieldNuPages.setText(bookSelectionated.getPages());
        textFieldGender.setText(bookSelectionated.getGender());
    }

    public void ModifyBook() {
        authorSelectionated = getAuthorBook(bookSelectionated.getAuthor());
        if (changeValuesBook(bookSelectionated, authorSelectionated, textFieldTitle.getText(), textFieldAuthorName.getText(), textFieldNuPages.getText(), textFieldGender.getText())) {
            JOptionPane.showMessageDialog(this, "The book " + bookSelectionated.getTitle() + " has been modified successfully", "Modify book", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }

    }

}
