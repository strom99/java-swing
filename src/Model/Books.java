package Model;

import java.awt.print.Book;

public class Books {
    private String title;
    private String gender;
    private String author;
    private String isbn ;
    private String pages;

    public Books(){}

    public Books(String title , String isbn ,String author, String pages,String gender){
        this.title = title;
        this.isbn = isbn;
        this.author = author;
        this.pages = pages;
        this.gender = gender;
    }

    public Books(String ISBN ){
        this.isbn = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPages() {
        return pages;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Books other = (Books) obj;
        return isbn.equalsIgnoreCase(other.isbn);
    }

    @Override
    public String toString() {
        return "Books{" +
                "title='" + title + '\'' +
                ", ISBN=" + isbn +
                ", NumberOfPages=" + pages +
                ", gender='" + gender + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
