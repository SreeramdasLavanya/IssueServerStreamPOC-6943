package com.ServerStreamMaxAge;

import io.grpc.stub.ServerCallStreamObserver;
import io.grpc.stub.StreamObserver;

// Example gRPC Service Implementation
public class TestServiceImpl extends TestServerStreamMaxAgeGrpc.TestServerStreamMaxAgeImplBase {
    @Override
    public void streamData(ServerStreamMaxAge.Empty request, StreamObserver<ServerStreamMaxAge.Response> responseObserver) {

        ServerCallStreamObserver<ServerStreamMaxAge.Response> serverCallStreamObserver =
                (ServerCallStreamObserver<ServerStreamMaxAge.Response>) responseObserver;

        serverCallStreamObserver.setOnCancelHandler(() -> {
            System.out.println("Call canceled by client or due to max connection age.");

        });

        for (int i = 0; i < 10; i++) {
            if (serverCallStreamObserver.isCancelled()) {
                System.out.println("Call was cancelled. Stopping data stream.");
                return; // Stop processing if the call is cancelled
            }

            try {
                // Create and send response message
                ServerStreamMaxAge.Response response = ServerStreamMaxAge.Response.newBuilder().setMessage("Message " + i).build();
                responseObserver.onNext(response);

                // Simulate processing delay
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt(); // Restore interrupted status
                responseObserver.onError(e);
                return;
            } catch (RuntimeException e) {
                System.out.println("Error occurred: " + e.getMessage());
                responseObserver.onError(e);
                return;
            }
        }
        responseObserver.onCompleted();
        System.out.println("Stream completed normally.");

        /*for (int i = 0; i < 10; i++) {
            try {
                // Sending response message to client
                ServerStreamMaxAge.Response response = ServerStreamMaxAge.Response.newBuilder().setMessage("Message " + i).build();
                responseObserver.onNext(response);

                // Simulate processing delay
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt(); // Restore interrupted status
                responseObserver.onError(e);
                return;
            } catch (RuntimeException e) {
                System.out.println("Error occurred: " + e.getMessage());
                responseObserver.onError(e);
                return;
            }
        }
        responseObserver.onCompleted();
        System.out.println("Stream completed normally.");*/
    }
}
