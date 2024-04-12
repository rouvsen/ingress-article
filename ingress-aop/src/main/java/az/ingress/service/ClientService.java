package az.ingress.service;

import org.springframework.stereotype.Service;

@Service
public class ClientService {

    public void executeProcess() {
        try {
            Thread.sleep(10000);
        } catch (Exception exception) {
            System.out.println("Error occurred!");
        }
    }
}
