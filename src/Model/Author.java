package Model;

public class Author {
    private String name;
    private String surname;
    private String secondSurname;
    private String country;

    public Author (){}

    public Author(String name){
        this.name = name;
    }

    public Author(String name , String surname ,String secondSurname){
        this.name = name;
        this.surname = surname;
        this.secondSurname = secondSurname;
    }

    public Author(String name , String surname ,String secondSurname , String country){
        this.name = name;
        this.surname = surname;
        this.secondSurname = secondSurname;
        this.country = country;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSecondSurname() {
        return secondSurname;
    }

    public void setSecondSurname(String secondSurname) {
        this.secondSurname = secondSurname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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
        final Author other = (Author) obj;
        return name.equalsIgnoreCase(other.name) && surname.equalsIgnoreCase(other.surname) && secondSurname.equalsIgnoreCase(other.secondSurname);
    }
}
