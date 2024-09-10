package com.StreamService;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class StreamServiceImpl extends StreamServiceGrpc.StreamServiceImplBase {

    @Override
    public void streamData(StreamServiceOuterClass.StreamRequest request, StreamObserver<StreamServiceOuterClass.StreamResponse> responseObserver) {
        // Cast to ServerCallStreamObserver to access advanced features
        ServerCallStreamObserver<StreamServiceOuterClass.StreamResponse> serverCallStreamObserver =
                (ServerCallStreamObserver<StreamServiceOuterClass.StreamResponse>) responseObserver;

        // Set a cancellation handler to log when the client cancels the call
        serverCallStreamObserver.setOnCancelHandler(() -> {
            System.out.println("Client has cancelled the call.");
        });

        // Simulate streaming data to the client
        for (; ; ) {
            if (serverCallStreamObserver.isCancelled()) {
                System.out.println("Stream was cancelled, stopping data transmission.");
                return; // Stop processing if the client has cancelled
            }
            try {
                // Simulate processing time
                Thread.sleep(1000);

                // Create a response message and send it to the client
                StreamServiceOuterClass.StreamResponse response = StreamServiceOuterClass.StreamResponse.newBuilder()
                        .setMessage("Data chunk " )
                        .build();

                System.out.println("Sending: " + response.getMessage());
                responseObserver.onNext(response);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                responseObserver.onError(e);
                return;
            } catch (Exception e) {
                System.err.println("Exception: " + e.getMessage());
                responseObserver.onError(new StatusRuntimeException(Status.INTERNAL.withDescription("Internal server error")));
            }
        }

        // Complete the streaming response
        //responseObserver.onCompleted();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = NettyServerBuilder.forPort(8080)
                .addService(new StreamServiceImpl())
                .maxConnectionAge(5, TimeUnit.SECONDS) // Close connections after 5 seconds
                .maxConnectionAgeGrace(2, TimeUnit.SECONDS) // Allow 2 seconds of grace period
                .build()
                .start();

        System.out.println("Server started on port 8080.");

        // Add shutdown hook
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("Shutting down server.");
            if (server != null) {
                server.shutdown();
            }
        }));

        server.awaitTermination();
    }
}

