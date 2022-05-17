package Views;

import Controller.ControllerBook;
import Model.Author;
import Model.Books;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Controller.ControllerAuthor.deleteAuthor;
import static Controller.ControllerAuthor.getAuthorByFullName;
import static Controller.ControllerBook.*;

public class DeleteBook extends JDialog {
    private JButton buttonDeleteBook;
    private JButton buttonCancelBook;
    private JComboBox comboBoxDeleteBook;
    private JPanel panelDeleteBook;

    public DeleteBook(JFrame parent, boolean model) {
        super(parent, model);
        setTitle("Delect Book");
        setContentPane(panelDeleteBook);
        setSize(500, 200);

        for (Books x : ControllerBook.getBooks()) {
            comboBoxDeleteBook.addItem(x.getIsbn() + "-" + x.getTitle());
        }
        buttonDeleteBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                windowDelete();
            }
        });
        buttonCancelBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void windowDelete() {
        int response = JOptionPane.showConfirmDialog(null, "Estas seguro???", "Seguro", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            Books x = getBookByIsbn((String) comboBoxDeleteBook.getSelectedItem());
            deleteBook(x);
            JOptionPane.showMessageDialog(this, "Eliminado Correctamente", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else {
            dispose();
        }
    }

}
