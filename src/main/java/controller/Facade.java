
package controller;

import integration.CurrenciesDAO;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import model.Currency;


/**
 *
 * @author Lazarko
 */
//REQUIRES_NEW
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class Facade {
    @EJB CurrenciesDAO cdb;
    
        
    // rates compared to dollar
    public static final double SEK = 0.11778;
    public static final double RSD = 0.00984;
    public static final double USD = 1.0;
    public static final double EUR = 1.17991;
    public static final double GBP = 1.33884;
    
    // Countries
    public static final String country_one = "Sweden";
    public static final String country_two = "Serbia";
    public static final String country_three = "USA";
    public static final String country_four = "Eurozone";
    public static final String country_five = "Greatbritain";
    
    public Currency addAll(){
        return addCurrency(SEK, country_one);
//        addCurrency(RSD, country_two);
//        addCurrency(USD, country_three);
//        addCurrency(EUR, country_four);
//        addCurrency(GBP, country_five);
    }
    public Currency addCurrency(double rate, String country){
        Currency currency = new Currency(rate, country);
        
        cdb.storeCurrency(currency);
        return currency;
    }
    
    public Currency findCurrency(int id){
        return cdb.findCurrency(id);
    }
    
    // CHECK HERE
    public double toDollar(int id, double amount){
        Currency currency = cdb.findCurrency(id);
        double dollar = currency.getRate() * amount;
        return dollar;
    }
}
