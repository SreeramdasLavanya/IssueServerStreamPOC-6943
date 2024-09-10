package com.StreamService;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class StreamServiceClient {

    public static void main(String[] args) throws InterruptedException {
        // Create a channel to connect to the server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        // Create a stub for making calls
        StreamServiceGrpc.StreamServiceStub stub = StreamServiceGrpc.newStub(channel);

        // Prepare the request
        StreamServiceOuterClass.StreamRequest request = StreamServiceOuterClass.StreamRequest.newBuilder()
                .setRequestId("client_request_1")
                .build();

        // Define the StreamObserver to handle the server response
        StreamObserver<StreamServiceOuterClass.StreamResponse> responseObserver = new StreamObserver<StreamServiceOuterClass.StreamResponse>() {
            @Override
            public void onNext(StreamServiceOuterClass.StreamResponse value) {
                System.out.println("Received: " + value.getMessage());
                // Simulate client cancellation after receiving the first response
                if (value.getMessage().contains("Data chunk 0")) {
                    System.out.println("Cancelling the call from the client...");
                    channel.shutdownNow(); // Simulate client-side cancellation
                }
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Stream completed from server.");
            }
        };

        // Start the call
        stub.streamData(request, responseObserver);

        // Wait for the call to complete
        channel.awaitTermination(5, TimeUnit.SECONDS);
    }
}

