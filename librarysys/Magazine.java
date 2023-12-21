/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysys;

import java.util.Objects;

/**
 *
 * @author ppu
 */
public class Magazine extends Book {
    private int issueNo;
    private MyDate releaseDate;
    private boolean onloan;

    public Magazine(int issueNo, MyDate releaseDate, boolean onloan, String title, Author author, int NO, String genre, int version, MyDate date) {
        super(title, author, NO, genre, version, date);
        this.issueNo = issueNo;
        this.releaseDate = releaseDate;
        this.onloan = onloan;
    }

    public int getIssueNo() {
        return issueNo;
    }

    public void setIssueNo(int issueNo) {
        this.issueNo = issueNo;
    }

    public MyDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(MyDate releaseDate) {
        this.releaseDate = releaseDate;
    }

 

    public void setOnloan(boolean onloan) {
        this.onloan = onloan;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.issueNo;
        hash = 17 * hash + Objects.hashCode(this.releaseDate);
        hash = 17 * hash + (this.onloan ? 1 : 0);
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Magazine other = (Magazine) obj;
        if (this.issueNo != other.issueNo) {
            return false;
        }
        if (this.onloan != other.onloan) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String getInfo() {
        return "Magazine" + super.getInfo() + " issueNo  : " + this.issueNo + "releaseDate : " + this.releaseDate.getInfo();
    }

    @Override
    public boolean inLoan() {
        return super.inLoan(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
