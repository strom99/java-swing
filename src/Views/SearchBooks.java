package Views;

import Controller.ControllerAuthor;
import Controller.ControllerBook;
import Model.Author;
import Model.Books;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Locale;
import java.util.List;

import static Controller.ControllerAuthor.getAuthorByFullName;
import static Controller.ControllerBook.*;

import Exception.*;

public class SearchBooks extends JDialog {

    Author authorSelectioned;
    Books bookSelectioned;
    DefaultTableModel model;

    private JComboBox comboBoxAuthors;
    private JComboBox comboBoxGenders;
    private JPanel panelBook;
    private JButton buttonSearchBook;
    private JButton buttonCancel;
    private JTable tableBooks;
    // title header Jtable
    String header[] = new String[]{"Title", "Isbn", "Author", "Gender", "Pages"};

    public SearchBooks(JFrame parent, boolean modal) {
        super(parent, modal);
        setTitle("Search Book");
        setContentPane(panelBook);
        model = (DefaultTableModel) tableBooks.getModel();
        // instance header title and rows for table
        model = new DefaultTableModel(header, 0);
        tableBooks.setModel(model);
        tableBooks.getTableHeader().setBackground(new Color(242, 204, 178));
        setSize(700, 400);

        // We add the first value null , so that the user decides when to search in a combo , or both
        comboBoxAuthors.addItem(null);
        for (Author x : ControllerAuthor.Authors) {
            comboBoxAuthors.addItem(x.getName() + " " + x.getSurname() + " " + x.getSecondSurname());
        }
        comboBoxAuthors.setSelectedItem(null);

        List<String> genres = new ArrayList<>();
        comboBoxGenders.addItem(null);
        for (Books x : Books) {
            if (!genres.contains(x.getGender())) {
                genres.add(x.getGender());
                comboBoxGenders.addItem(x.getGender());
            }
        }
        comboBoxGenders.setSelectedItem(null);


        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonSearchBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    windowSearch();
                } catch (AuthorException ex) {
                    ex.getMessage();
                }
            }
        });
    }

    public void windowSearch() throws AuthorException {
        model.setRowCount(0);

        try {
            //  books for author
            if (comboBoxAuthors.getSelectedItem() != null && comboBoxGenders.getSelectedItem() == null) {
                authorSelectioned = getAuthorByFullName((String) comboBoxAuthors.getSelectedItem());
                ArrayList<String> listBooks = searchBooksAuthor(authorSelectioned);
                model.setRowCount(0);
                for (int i = 0; i < listBooks.size(); i++) {
                    bookSelectioned = getObjetcBooks(listBooks.get(i));
                    Object[] objs = {bookSelectioned.getTitle(), bookSelectioned.getIsbn(), bookSelectioned.getAuthor(), bookSelectioned.getGender(), bookSelectioned.getPages()};
                    model.addRow(objs);
                }
             // books for gender
            } else if (comboBoxGenders.getSelectedItem() != null && comboBoxAuthors.getSelectedItem() == null) {
                for (Books book : getBooksByGenre((String) comboBoxGenders.getSelectedItem())) {
                    Object[] objs = {book.getTitle(), book.getIsbn(), book.getAuthor(), book.getGender(), book.getPages()};
                    model.addRow(objs);
                }
                // select book for gender and author
            } else if (comboBoxAuthors.getSelectedItem() != null && comboBoxGenders.getSelectedItem() != null) {
                for (Books book : getBooksByGenreAndAuthor((String) comboBoxGenders.getSelectedItem(), getAuthorByFullName((String) comboBoxAuthors.getSelectedItem()))) {
                    Object[] objs = {book.getTitle(), book.getIsbn(), book.getAuthor(), book.getGender(), book.getPages()};
                    model.addRow(objs);
                }
            }else if(comboBoxAuthors.getSelectedItem() == null && comboBoxGenders.getSelectedItem() == null){
                for (Model.Books book : Books){
                    Object[] objs = {book.getTitle(), book.getIsbn(), book.getAuthor(), book.getGender(), book.getPages()};
                    model.addRow(objs);
                }
            }
        } catch (AuthorException | NullPointerException | IndexOutOfBoundsException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error loading combobox", JOptionPane.ERROR_MESSAGE);
        }
    }

}
