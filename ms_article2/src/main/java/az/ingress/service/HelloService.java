package az.ingress.service;

import az.ingress.domain.HelloEntity;
import az.ingress.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final HelloRepository helloRepository;

    public ResponseEntity<String> callHello() {
        HelloEntity helloEntity = helloRepository.findById(1).orElseGet(
                () -> helloRepository.save(HelloEntity.builder().callCount(0).build())
        );
        helloEntity.setCallCount(helloEntity.getCallCount() + 1);
        return new ResponseEntity<>(
                "Hello from Article-2 MS, count: %s".formatted(helloRepository.save(helloEntity).getCallCount()),
                HttpStatus.OK
        );
    }
}
