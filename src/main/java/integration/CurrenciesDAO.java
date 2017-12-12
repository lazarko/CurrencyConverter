

package integration;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import model.Currency;


/**
 *
 * @author Lazarko
 */
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Stateless
public class CurrenciesDAO {
    @PersistenceContext(unitName = "currenciesPU")
    private EntityManager em;
    
    public Currency findCurrency(Integer id){
        Currency currency = em.find(Currency.class, id);
        if(currency == null){
            throw new EntityNotFoundException("Id invalid");
        }
        return currency;
    }
    
    public Currency findCurrByCountry(String country){
        Currency currency = (Currency) em.createNamedQuery("findCurrencyByCountry", Currency.class).
                setParameter("c", country).getSingleResult();
        return currency;
    }
    
    public void storeCurrency(Currency curr){
        em.persist(curr);
    }
    
}
