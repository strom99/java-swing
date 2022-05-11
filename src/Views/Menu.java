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
    private JLabel iconBook;
    private JLabel titleLibrary;
    private JButton newButtonAuthors;
    private JButton modifyButtonAuthor;
    private JButton removeButtonAuthor;
    private JButton newButtonBook;
    private JButton modifyButtonBook;
    private JButton removeButtonBook;
    private JButton searchButtonBook;
    private JLabel titleAuthor;
    private JLabel titleBooks;
    private JPanel panelMain;
    private JPanel seccionTitle;

    public Menu() {
        // imprecindible to run the codig
        setContentPane(panelMain);
        pack();
        setTitle("Welcome");
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        Authors.add(new Author("caca", "caca", "caca", "caca"));
        Authors.add(new Author("test", "test", "test", "test"));

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
            JOptionPane.showMessageDialog(this, "No hay Autores registrados", "Sin Autores", JOptionPane.INFORMATION_MESSAGE);
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
            JOptionPane.showMessageDialog(this, "No hay Autores registrados", "Sin Autores", JOptionPane.INFORMATION_MESSAGE);
        } else {
            DeleteAuthor x = new DeleteAuthor(this, true);
            x.setLocationRelativeTo(null);
            x.setVisible(true);
        }
    }

    public void windowRegisterBook() {
        if (Authors.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aun No hay Autores registrados", "Sin Autores", JOptionPane.INFORMATION_MESSAGE);
        } else {
            RegisterBook windowBookRegister = new RegisterBook(this, true);
            windowBookRegister.setLocationRelativeTo(null);
            windowBookRegister.setVisible(true);
        }
    }

    public void modifyBookWindow() {
        if (ControllerBook.getBooks().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aun No hay libros registradpos", "Sin libros", JOptionPane.INFORMATION_MESSAGE);
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

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panelMain = new JPanel();
        panelMain.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(10, 5, new Insets(0, 0, 0, 0), -1, -1));
        panelMain.setBackground(new Color(-785));
        seccionTitle = new JPanel();
        seccionTitle.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        seccionTitle.setBackground(new Color(-865102));
        panelMain.add(seccionTitle, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 5, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        titleLibrary = new JLabel();
        Font titleLibraryFont = this.$$$getFont$$$("Courier New", Font.BOLD, 24, titleLibrary.getFont());
        if (titleLibraryFont != null) titleLibrary.setFont(titleLibraryFont);
        titleLibrary.setText("Library");
        seccionTitle.add(titleLibrary, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        iconBook = new JLabel();
        iconBook.setIcon(new ImageIcon(getClass().getResource("/Images/book.png")));
        iconBook.setText("");
        seccionTitle.add(iconBook, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        newButtonAuthors = new JButton();
        Font newButtonAuthorsFont = this.$$$getFont$$$("Andale Mono", Font.PLAIN, 18, newButtonAuthors.getFont());
        if (newButtonAuthorsFont != null) newButtonAuthors.setFont(newButtonAuthorsFont);
        newButtonAuthors.setText("New");
        panelMain.add(newButtonAuthors, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        modifyButtonAuthor = new JButton();
        Font modifyButtonAuthorFont = this.$$$getFont$$$("Andale Mono", Font.PLAIN, 18, modifyButtonAuthor.getFont());
        if (modifyButtonAuthorFont != null) modifyButtonAuthor.setFont(modifyButtonAuthorFont);
        modifyButtonAuthor.setText("Modify");
        panelMain.add(modifyButtonAuthor, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        removeButtonAuthor = new JButton();
        Font removeButtonAuthorFont = this.$$$getFont$$$("Andale Mono", Font.PLAIN, 18, removeButtonAuthor.getFont());
        if (removeButtonAuthorFont != null) removeButtonAuthor.setFont(removeButtonAuthorFont);
        removeButtonAuthor.setText("Remove");
        panelMain.add(removeButtonAuthor, new com.intellij.uiDesigner.core.GridConstraints(5, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        newButtonBook = new JButton();
        Font newButtonBookFont = this.$$$getFont$$$("Andale Mono", Font.PLAIN, 18, newButtonBook.getFont());
        if (newButtonBookFont != null) newButtonBook.setFont(newButtonBookFont);
        newButtonBook.setText("New");
        panelMain.add(newButtonBook, new com.intellij.uiDesigner.core.GridConstraints(3, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        modifyButtonBook = new JButton();
        Font modifyButtonBookFont = this.$$$getFont$$$("Andale Mono", Font.PLAIN, 18, modifyButtonBook.getFont());
        if (modifyButtonBookFont != null) modifyButtonBook.setFont(modifyButtonBookFont);
        modifyButtonBook.setText("Modify");
        panelMain.add(modifyButtonBook, new com.intellij.uiDesigner.core.GridConstraints(4, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        removeButtonBook = new JButton();
        Font removeButtonBookFont = this.$$$getFont$$$("Andale Mono", Font.PLAIN, 18, removeButtonBook.getFont());
        if (removeButtonBookFont != null) removeButtonBook.setFont(removeButtonBookFont);
        removeButtonBook.setText("Remove");
        panelMain.add(removeButtonBook, new com.intellij.uiDesigner.core.GridConstraints(5, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        searchButtonBook = new JButton();
        Font searchButtonBookFont = this.$$$getFont$$$("Andale Mono", Font.PLAIN, 18, searchButtonBook.getFont());
        if (searchButtonBookFont != null) searchButtonBook.setFont(searchButtonBookFont);
        searchButtonBook.setText("Search");
        panelMain.add(searchButtonBook, new com.intellij.uiDesigner.core.GridConstraints(6, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        titleAuthor = new JLabel();
        Font titleAuthorFont = this.$$$getFont$$$("Andale Mono", Font.PLAIN, 18, titleAuthor.getFont());
        if (titleAuthorFont != null) titleAuthor.setFont(titleAuthorFont);
        titleAuthor.setText("Authors");
        panelMain.add(titleAuthor, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        titleBooks = new JLabel();
        Font titleBooksFont = this.$$$getFont$$$("Andale Mono", Font.PLAIN, 18, titleBooks.getFont());
        if (titleBooksFont != null) titleBooks.setFont(titleBooksFont);
        titleBooks.setText("Books");
        panelMain.add(titleBooks, new com.intellij.uiDesigner.core.GridConstraints(2, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panelMain.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(9, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panelMain.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panelMain.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(8, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        panelMain.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(7, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        panelMain.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(3, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        panelMain.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        panelMain.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panelMain;
    }

}
