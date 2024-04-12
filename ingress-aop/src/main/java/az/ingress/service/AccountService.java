package az.ingress.service;

import az.ingress.annotation.custom.CustomTransactional;
import az.ingress.domain.Account;
import az.ingress.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    @CustomTransactional
    public void saveAccountChecked() throws Exception {
        repository.save(Account.builder()
                .name("Account - 1")
                .build()
        );
        throw new Exception("Thrown Checked Exception !!");
    }

    @CustomTransactional
    public void saveAccountUnChecked() {
        repository.save(Account.builder()
                .name("Account - 1")
                .build()
        );
        throw new RuntimeException("Thrown Unchecked Exception !");
    }

//    @CustomTransactional
//    public void transferMoney(Long fromAccountId, Long toAccountId, Double amount) throws Exception {
        //logics
//    }

}
