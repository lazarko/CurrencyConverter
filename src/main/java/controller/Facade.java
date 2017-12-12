
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
    

    public Currency addCurrency(double rate, String country){
        Currency currency = new Currency(rate, country);
        
        cdb.storeCurrency(currency);
        return currency;
    }
    
    public Currency findCurrency(int id){
        return cdb.findCurrency(id);
    }
    
    
    public double toDollar(Currency currency, double amount){
        double dollar = currency.getRate() * amount;
        return dollar;
    }
}
