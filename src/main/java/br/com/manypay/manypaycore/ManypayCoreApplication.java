package br.com.manypay.manypaycore;

import br.com.manypay.manypaycore.model.*;
import br.com.manypay.manypaycore.providers.CieloProvider;
import br.com.manypay.manypaycore.providers.PaymentProvider;
import br.com.manypay.manypaycore.services.FacadeTransaction;
import br.com.manypay.manypaycore.services.RequestApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManypayCoreApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ManypayCoreApplication.class, args);
    }

    public void run(String... args) throws Exception {

        PaymentProvider cieloAquirer = new CieloProvider(REDACTED);
        RequestApi cieloRequest = new RequestApi(cieloAquirer);
        PaymentStrategy creditStrategy = new CreditStrategy();
        CreditCard creditCard = new CreditCard(REDACTED);
        CreditPayment creditPayment = new CreditPayment(1, 200, creditStrategy, true);
        FacadeTransaction cieloCreditTransaction = new FacadeTransaction(cieloAquirer, cieloRequest, creditStrategy, creditCard, creditPayment);

        cieloCreditTransaction.sendTransactionToAcquirer();
        cieloCreditTransaction.queryTransactionDataOnAcquirer();
        cieloCreditTransaction.readTransactionLog();
    }
}
