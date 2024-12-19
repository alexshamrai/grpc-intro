package io.github.alexshamrai.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionServiceV1;

import java.io.IOException;

public class HelloServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
            .forPort(6565)
            .addService(new HelloServiceImpl())
            .addService(ProtoReflectionServiceV1.newInstance())
            .build();

        server.start();
        server.awaitTermination();
    }
}