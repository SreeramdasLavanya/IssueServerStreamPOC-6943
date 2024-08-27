package com.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GrpcServer {

    private static final int THREAD_POOL_SIZE = 100;
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public static void main(String args[]) throws InterruptedException, IOException {
        Server server = ServerBuilder.forPort(8081).addService(new GreeterService()).build();
        server.start();
        System.out.println("Server started at " + server.getPort());
        server.awaitTermination();
    }
}
