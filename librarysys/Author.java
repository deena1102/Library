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
public class Author {
    private int ID ; 
    private String Name ; 
    private String address ;
    private MyDate BD ;
    

    public Author(int ID, String Name, String address, MyDate BD) {
        this.ID = ID;
        this.Name = Name;
        this.address = address;
        this.BD = BD;
    }

 
    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public MyDate getBD() {
        return BD;
    }

    public void setBD(MyDate BD) {
        this.BD = BD;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }    
    
    public String getInfo()
    {
        return "ID : " + this.ID + " , Name : " + this.Name + ", Address : " + this.address + " , Date of BirthDay : " +this.BD.getInfo();                
        
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
        final Author other = (Author) obj;
        if (this.ID != other.ID) {
            return false;
        }
        if (!Objects.equals(this.Name, other.Name)) {
            return false;
        }
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        if (!Objects.equals(this.BD, other.BD)) {
            return false;
        }
        return true;
    }
    

}
