

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
    private Currency secondCurrency;
    private Integer searchedId;
    private Integer searchId2;
    private double rate;
    private String country;
    private String country2;
    
    Integer id_SEK = 1;
    Integer id_RSD = 2;
    Integer id_USD = 3;
    Integer id_EUR = 4;
    Integer id_GBP = 5;
    

    private double amount;
    private double converted;
    private double toDollar;
    
    public void addCurrencies(){
        try{
             currency = facade.addCurrency(Info.SEK, Info.Country1);
             currency = facade.addCurrency(Info.RSD, Info.Country2);
             currency = facade.addCurrency(Info.USD, Info.Country3);
             currency = facade.addCurrency(Info.EUR, Info.Country4);
             currency = facade.addCurrency(Info.GBP, Info.Country5);            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void convert(){
        //try{
            findCurrency(true, country);
            findCurrency(false, country2);
            setAmount(amount);
            //setToDollar(facade.toDollar(searchedId, amount));
            setConverted((facade.toDollar(searchedId, amount))/secondCurrency.getRate()); 
        //}//catch(Exception e){
            System.out.println("FUCK");
        //}
    }
        
    public void findCurrency(boolean id, String countryId){
        try{
            setValues(id, countryId);
            if(id == true){
                currency = facade.findCurrency(searchedId);
            }else{
                secondCurrency = facade.findCurrency(searchId2);
            }
  
        }catch(Exception e){
            System.out.println("CANNOT FIND currency");
        }
    }
    // TODO : CASE IGNORE
    private void setValues(boolean id, String countryId){
        switch(countryId){
            case Info.Country1:
                setCurrencyId(id_SEK, id);
                break;
            case Info.Country2:
                setCurrencyId(id_RSD, id);
                break;
            case Info.Country3:
                setCurrencyId(id_USD, id);
                break;
            case Info.Country4:
                setCurrencyId(id_EUR, id);
                break;
            case Info.Country5:
                setCurrencyId(id_GBP, id);
                break;
            default :
                setCurrencyId(null, id);
        }     
    }
    
    
    //SETTERS
    public void setCurrencyId(Integer searchedId, boolean id){
        if(id == true){
            this.searchedId = searchedId;
        }else{
            this.searchedId = searchId2;
        }
    }
    public void setRate(double rate){
        this.rate = rate;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public void setCountry2(String country2){
        this.country2 = country2;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    
    public void setSearchIdTwo(Integer searchId2){
        this.searchId2 = searchId2;
    }

    public void setToDollar(double toDollar){
        this.toDollar = toDollar;
    }
    public void setConverted(double converted){
        this.converted = converted;
    }
    
    
    // GETTERS 
    public double getToDollar(){
        return toDollar;
    }
    public Currency getCurrency(){
        return currency;
    }
    
    public double getAmount(){
        return amount;
    }
    public double getRate(){
        return rate;
    }
    public String getCountry(){
        return country;
    }
    public String getCountry2(){
        return country2;
    }
    public double getConverted(){
        return converted;
    }
    
}
