

package view;

import controller.Facade;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import model.Currency;

/**
 *
 * @author Lazarko
 */
@Named("handler")
@ManagedBean
public class Handler implements Serializable {
    @EJB
    private Facade facade;
    private Currency currency;
    private Integer searchedId;
    private double rate;
    private String country;
    
    private double amount;
    
    public void addCurrencies(){
        try{
             currency = facade.addAll();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public double convert(int input, int output, double amount){
        double dollar = facade.toDollar(input, amount);
        currency = facade.findCurrency(output);
        return dollar/currency.getRate();
    } 
    
    public void findCurrency(){
        try{
            currency = facade.findCurrency(searchedId);
        }catch(Exception e){
            System.out.println("CANNOT FIND currency");
        }
    }
    
    public void setCurrencyId(Integer searchedId){
        this.searchedId = searchedId;
    }
    public void setRate(double rate){
        this.rate = rate;
    }
    public void setCountry(String country){
        this.country = country;
    }
    

    public Currency getCurrency(){
        return currency;
    }
    
    public double getRate(){
        return rate;
    }
    public String getCountry(){
        return country;
    }
    public void readCurrData(){
        searchedId = currency.getId();
        findCurrency();
    }
}
