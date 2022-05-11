package Model;

public class Books {
    private String title;
    private int ISBN;
    private int NumberOfPages;
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

    public Books(String title , int ISBN,String author, int NumberOfPages,String gender){
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.NumberOfPages = NumberOfPages;
        this.gender = gender;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public int getNumberOfPages() {
        return NumberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        NumberOfPages = numberOfPages;
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
                ", ISBN=" + ISBN +
                ", NumberOfPages=" + NumberOfPages +
                ", gender='" + gender + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
