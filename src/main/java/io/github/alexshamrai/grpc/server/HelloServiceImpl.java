package io.github.alexshamrai.grpc.server;

import io.github.alexshamrai.grpc.HelloRequest;
import io.github.alexshamrai.grpc.HelloResponse;
import io.github.alexshamrai.grpc.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(
        HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        String greeting = "Hello, "
                          + request.getFirstName()
                          + " "
                          + request.getLastName();

        HelloResponse response = HelloResponse.newBuilder()
            .setGreeting(greeting)
            .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
