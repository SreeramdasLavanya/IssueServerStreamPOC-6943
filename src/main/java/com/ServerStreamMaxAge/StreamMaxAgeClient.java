package com.ServerStreamMaxAge;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class StreamMaxAgeClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8085)
                .usePlaintext()
                .build();

        TestServerStreamMaxAgeGrpc.TestServerStreamMaxAgeStub asyncStub = TestServerStreamMaxAgeGrpc.newStub(channel);

        StreamObserver<ServerStreamMaxAge.Response> responseObserver = new StreamObserver<>() {
            @Override
            public void onNext(ServerStreamMaxAge.Response response) {
                System.out.println("Received: " + response.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Error: " + t);
            }

            @Override
            public void onCompleted() {
                System.out.println("Stream completed");
                channel.shutdown();
            }
        };

        // Invoke the server-streaming RPC
        asyncStub.streamData(ServerStreamMaxAge.Empty.newBuilder().build(), responseObserver);

        try {
            Thread.sleep(15000); // Keep client running for enough time to see the effect
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
