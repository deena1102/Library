/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysys;
import java.util.ArrayList;
import java.util.Objects;
/**
 *
 * @author ppu
 */
public class Student extends Author{
    
    private String major; 
    ArrayList<Book> loanedBooks;

    public Student( int ID, String Name, String address, MyDate BD, String major) {
        super(ID, Name, address, BD);
        this.major = major;
        this.loanedBooks = new ArrayList<>();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public ArrayList<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void setLoanedBooks(ArrayList<Book> loanedBooks) {
        this.loanedBooks = loanedBooks;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.major);
        hash = 23 * hash + Objects.hashCode(this.loanedBooks);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.major, other.major)) {
            return false;
        }
        if (!Objects.equals(this.loanedBooks, other.loanedBooks)) {
            return false;
        }
        return true;
    }
    
     @Override
    public String getInfo() 
    {
        return super.getInfo() + "Majer : " + this.major;
    }
    
    

    public void addLoanedBook(Book book) {
        loanedBooks.add(book);
    }

    public void removeLoanedBook(Book book) {
        loanedBooks.remove(book);
    }
    
    
}
