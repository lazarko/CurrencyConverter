
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lazarko
 */
@Entity
public class Currency implements Serializable {

  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private double rate;
    private String country;
    
    public Currency(){
        
    }
    
    public Currency(double rate, String country){
        this.rate = rate;
        this.country = country;
    }

    public double getRate() {
        return rate;
    }

    public String getCountry() {
        return country;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Currency[ id=" + id + " ]";
    }
    
}
