package io.codhao.mygrpcclient.controller;


import io.codhao.mygrpcclient.client.MyGrpcServerClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class TestController {

    private final MyGrpcServerClient client;

    @PostMapping("hello")
    public String test(@RequestBody HelloDto req) {
        return client.receiveGreeting(req.name());
    }
}
