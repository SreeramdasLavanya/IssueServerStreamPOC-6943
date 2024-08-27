package com.example.grpc;

import com.example.grpc.StreamExampleProto.Request;
import com.example.grpc.StreamExampleProto.Response;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class StreamClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8084)
                .usePlaintext()
                .build();

        ExampleServiceGrpc.ExampleServiceStub stub = ExampleServiceGrpc.newStub(channel);

        Request request = Request.newBuilder()
                .setQuery("Test query")
                .build();

        stub.streamResults(request, new StreamObserver<Response>() {
            @Override
            public void onNext(Response response) {
                System.out.println("Received: " + response.getResult());
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
        });

        // Wait for the stream to complete
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
