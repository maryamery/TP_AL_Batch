package ma.ensa.bankspringbatch.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class BankTransaction {
    @Id
    
    //not adding @GeneratedValue because we are processing existing data
    private long id;
    private long accountID;
    private Date transactionDate;
    
    //to avoid date format problems in the itemReader

    @Transient //strTransactionDate not to be persisted in the database
    private String strTransactionDate;
    private double amount;


}
