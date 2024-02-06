package io.codhao.mygrpcclient.client;

import io.codhao.starterproto.HelloRequest;
import io.codhao.starterproto.HelloServiceGrpc;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class MyGrpcServerClient {

    // take config from application yaml
    @GrpcClient("HelloService")
    private HelloServiceGrpc.HelloServiceBlockingStub serviceStub;

    public String receiveGreeting(String name) {
        long startTime = System.nanoTime();
        System.out.println("receiving greeting with : " + name);
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name)
                .build();
        String message = serviceStub.sayHello(request).getMessage();

        long durationInNano = System.nanoTime() - startTime;
        double durationInMilliseconds = (double) durationInNano / 1_000_000; // Convert nanoseconds to milliseconds

        System.out.println("Duration: " + durationInMilliseconds + " ms");
        return message;
    }


}
