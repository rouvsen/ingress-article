package az.ingress.controller;

import az.ingress.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hello")
public class HelloController {

    private final HelloService helloService;

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return helloService.callHello();
    }
}
