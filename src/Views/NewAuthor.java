package Views;

import Controller.ControllerAuthor;
import Model.Author;
import Exception.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Controller.ControllerAuthor.register;

public class NewAuthor extends JDialog {
    private JButton buttonAccept;
    private JButton buttonCancel;
    private JTextField textFieldSurname;
    private JTextField textFieldSeSurname;
    private JTextField textFieldCountry;
    private JTextField textFieldname;
    private JPanel panelForm;

    public NewAuthor(Frame parent, boolean modal) {
        super(parent, modal);
        pack();
        setTitle("Register Author");
        setContentPane(panelForm);
        setSize(700, 500);

        buttonAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registerAuthor();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void registerAuthor() {
        String name = textFieldname.getText();
        String surname = textFieldSurname.getText();
        String SeSurname = textFieldSeSurname.getText();
        String country = textFieldCountry.getText();

        if (name.isEmpty() || surname.isEmpty() || SeSurname.isEmpty() || country.isEmpty()) {
            JOptionPane.showMessageDialog(this, "You can not leave empty fields", "Information author", JOptionPane.WARNING_MESSAGE);
        } else {
            Author u = new Author(name, surname, SeSurname, country);
            try {
                register(u);
                JOptionPane.showMessageDialog(this, "Registered author", "Registered", JOptionPane.INFORMATION_MESSAGE);
                // check
                dispose();
            } catch (AuthorException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error to registered", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


}
