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
public class Journals extends Book{
   private String conferenceName;
   private int conferenceNo;
   private boolean onloan;

    public Journals(String conferenceName, int conferenceNo, boolean onloan, String title, Author author, int NO, String genre, int version, MyDate date) {
        super(title, author, NO, genre, version, date);
        this.conferenceName = conferenceName;
        this.conferenceNo = conferenceNo;
        this.onloan = onloan;
    }

    public String getConferenceName() {
        return conferenceName;
    }

    public void setConferenceName(String conferenceName) {
        this.conferenceName = conferenceName;
    }

    public int getConferenceNo() {
        return conferenceNo;
    }

    public void setConferenceNo(int conferenceNo) {
        this.conferenceNo = conferenceNo;
    }


    public void setOnloan(boolean onloan) {
        this.onloan = onloan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.conferenceName);
        hash = 83 * hash + this.conferenceNo;
        hash = 83 * hash + (this.onloan ? 1 : 0);
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
        final Journals other = (Journals) obj;
        if (this.conferenceNo != other.conferenceNo) {
            return false;
        }
        if (this.onloan != other.onloan) {
            return false;
        }
        if (!Objects.equals(this.conferenceName, other.conferenceName)) {
            return false;
        }
        return true;
    }
    
    @Override
 public String getInfo ()
 {
     return "Journals" + super.getInfo() + "conferenceNo : " +this.conferenceNo + "getConferenceName : " + this.conferenceName;
 }

    @Override
    public boolean inLoan() {
        
        return onloan;
    }
 

    
    
}
