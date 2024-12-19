package io.github.alexshamrai.grpc.client;

import io.github.alexshamrai.grpc.HelloRequest;
import io.github.alexshamrai.grpc.HelloResponse;
import io.github.alexshamrai.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class HelloClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565)
            .usePlaintext()
            .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
            .setFirstName("Alex")
            .setLastName("Shamrai")
            .build());

        System.out.println(helloResponse.getGreeting());

        channel.shutdown();
    }
}
