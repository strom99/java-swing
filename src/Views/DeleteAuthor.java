package Views;

import Controller.ControllerAuthor;
import Controller.ControllerBook;
import Model.Author;
import Model.Books;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static Controller.ControllerAuthor.deleteAuthor;
import static Controller.ControllerAuthor.getAuthorByFullName;
import static Controller.ControllerBook.getBookByIsbn;
import static Controller.ControllerBook.searchBooksAuthor;

public class DeleteAuthor extends JDialog {

    private JComboBox comboBoxAuthorsDelete;
    private JButton buttonCancel;
    private JButton buttonDelete;
    private JPanel panelDelete;

    public DeleteAuthor(JFrame parent, boolean modal) {
        super(parent, modal);
        pack();
        setTitle("Delete Authors");
        setContentPane(panelDelete);
        setSize(500, 400);

        // adding authors to the combobox
        for (Author u : ControllerAuthor.getAuthors()) {
            comboBoxAuthorsDelete.addItem(u.getName() + " " + u.getSurname() + " " + u.getSecondSurname());

        }

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    delete();
                    dispose();
                } catch (Exception ex) {
                    ex.getMessage();
                }
            }
        });
    }

    public void delete() throws Exception {
        // confirmacion delete
        int response = JOptionPane.showConfirmDialog(null, "Are you sure???", "Delete confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (response == JOptionPane.YES_OPTION) {
            Author x = getAuthorByFullName((String) comboBoxAuthorsDelete.getSelectedItem());
            deleteAuthor(x);
            // search books by author
            ArrayList<String> X = searchBooksAuthor(x);
            // delete Author's book
            for (String libros : X) {
                Books s = getBookByIsbn(libros);
                ControllerBook.Books.remove(s);
            }
            JOptionPane.showMessageDialog(this, "Removed successfully", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            dispose();
        }

    }

}
