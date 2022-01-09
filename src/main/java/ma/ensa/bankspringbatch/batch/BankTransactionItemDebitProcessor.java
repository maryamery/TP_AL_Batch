package ma.ensa.bankspringbatch.batch;

import lombok.Getter;
import ma.ensa.bankspringbatch.dao.BankTransaction;
import org.springframework.batch.item.ItemProcessor;

public class BankTransactionItemDebitProcessor implements ItemProcessor<BankTransaction, BankTransaction> {

    @Getter
    private double totalDebit;

    @Override
    public BankTransaction process(BankTransaction bankTransaction) {
         totalDebit += bankTransaction.getAmount();
         return bankTransaction;
    }
    }
