package com.ServerStreamMaxAge;

import io.grpc.*;
import io.grpc.Context;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

public class StreamMaxAgeServer {
    private Server server;

    public void start() throws IOException {
        server = ServerBuilder.forPort(8085)
                .addService(new TestServiceImpl())  // Add service implementation
                .maxConnectionAge(5, TimeUnit.SECONDS)  // Set maximum connection age to 5 seconds
                .maxConnectionAgeGrace(2, TimeUnit.SECONDS)  // Set grace period to 2 seconds
               // .intercept(new MyServerInterceptor())  // Add the interceptor to handle onCancel
                .build()
                .start();

        System.out.println("Server started, listening on 8085");

        // Handle server shutdown
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down");
            try {
                StreamMaxAgeServer.this.stop();
            } catch (InterruptedException e) {
                e.printStackTrace(System.err);
            }
            System.err.println("*** server shut down");
        }));
    }

    public void stop() throws InterruptedException {
        if (server != null) {
            server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final StreamMaxAgeServer server = new StreamMaxAgeServer();
        server.start();
        server.server.awaitTermination();
    }
}
