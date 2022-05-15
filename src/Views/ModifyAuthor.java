package Views;

import Controller.ControllerAuthor;
import Controller.ControllerBook;
import Model.Author;

import javax.swing.*;
import Exception.AuthorException;
import Model.Books;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import static Controller.ControllerAuthor.*;
import static Controller.ControllerBook.getBookByIsbn;

public class ModifyAuthor extends JDialog {
    Author authorSelectioned;

    private JComboBox comboBoxAuthors;
    private JButton selectButtonAuthor;
    private JTextField textFieldModifyName;
    private JTextField textFieldSeSurname;
    private JButton buttonModify;
    private JTextField textFieldSurname;
    private JTextField textFieldCountry;
    private JPanel panelModify;
    private JButton buttonCancelModify;

    public ModifyAuthor(JFrame parent, boolean modal) {
        super(parent, modal);
        pack();
        setTitle("Modify Author");
        setContentPane(panelModify);
        setSize(600, 500);

        for (Author u : ControllerAuthor.getAuthors()) {
            comboBoxAuthors.addItem(u.getName() + " " + u.getSurname() + " " + u.getSecondSurname());
        }


        selectItem();
        // cancel modify
        buttonCancelModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        // save modify Author
        buttonModify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifyAction();
            }
        });

        // select user combobox
        selectButtonAuthor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectItem();
            }
        });

        comboBoxAuthors.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                System.out.println("Selected item + " + e);
            }
        });

    }

    public void selectItem() {
        try {
            authorSelectioned = getAuthorByFullName((String) comboBoxAuthors.getSelectedItem());
            textFieldModifyName.setText(authorSelectioned.getName());
            textFieldSurname.setText(authorSelectioned.getSurname());
            textFieldSeSurname.setText(authorSelectioned.getSecondSurname());
            textFieldCountry.setText(authorSelectioned.getCountry());
        } catch (AuthorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error loading authors", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modifyAction() {
        try {
            if (textFieldModifyName.getText().isEmpty() || textFieldSurname.getText().isEmpty() || textFieldSeSurname.getText().isEmpty()) {
                throw new AuthorException("You can not leave empty fields");
            }
            modifyAuthor(authorSelectioned, textFieldModifyName.getText(), textFieldSurname.getText(), textFieldSeSurname.getText(), textFieldCountry.getText());
            JOptionPane.showMessageDialog(this, "The author" + authorSelectioned.getName() + " has been successfully modified", "Modify Author", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (AuthorException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
