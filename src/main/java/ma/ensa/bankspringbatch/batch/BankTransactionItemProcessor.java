package ma.ensa.bankspringbatch.batch;

import ma.ensa.bankspringbatch.dao.BankTransaction;
import org.springframework.batch.item.ItemProcessor;

import java.text.SimpleDateFormat;


public class BankTransactionItemProcessor implements ItemProcessor<BankTransaction,BankTransaction> {
    private SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy HH:mm");
    
    @Override
    public BankTransaction process(BankTransaction bankTransaction) throws Exception {
        bankTransaction.setTransactionDate(dateFormat.parse(bankTransaction.getStrTransactionDate()));
        return bankTransaction;
    }
}
