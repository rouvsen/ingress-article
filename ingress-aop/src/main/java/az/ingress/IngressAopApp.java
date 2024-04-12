package az.ingress;

import az.ingress.service.AccountService;
import az.ingress.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class IngressAopApp implements CommandLineRunner {

//    private final ClientService clientService;
    private final AccountService accountService;

    public static void main(String[] args) {
        SpringApplication.run(IngressAopApp.class, args);
    }

    @Override
    public void run(String... args) throws Exception{

//        clientService.executeProcess();

        accountService.saveAccountChecked();

//        accountService.saveAccountUnChecked();

    }
}
