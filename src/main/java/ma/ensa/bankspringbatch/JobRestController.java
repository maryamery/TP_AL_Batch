package ma.ensa.bankspringbatch;

import ma.ensa.bankspringbatch.batch.BankTransactionItemDebitProcessor;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class JobRestController {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;
    @Autowired
    private BankTransactionItemDebitProcessor itemDebitProcessor;


    @GetMapping("/startJob")
    public BatchStatus load() throws Exception{
        Map<String, JobParameter> jobParameterMap = new HashMap<>();
        jobParameterMap.put("time",new JobParameter(System.currentTimeMillis()));//Only one time parameter is used
        JobParameters jobParameters=new JobParameters(jobParameterMap);
        JobExecution jobExecution=jobLauncher.run(job,jobParameters);//JobExecution creation
        while (jobExecution.isRunning()){ // using the while loop because the JobExecution is executed in a Thread
            System.out.println(".....");
        }
        return jobExecution.getStatus();
    }


    @GetMapping("/debit")
    public Map<String,Double> debit(){
        Map<String,Double> map=new HashMap<>();
        map.put("TotalDebit",itemDebitProcessor.getTotalDebit());
        return map;
    }
}
