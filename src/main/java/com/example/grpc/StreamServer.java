package com.example.grpc;

import com.example.grpc.StreamExampleProto.Request;
import com.example.grpc.StreamExampleProto.Response;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class StreamServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(8084)
                .addService(new ExampleServiceImpl())
                .build();

        System.out.println("Server started...");
        server.start();
        server.awaitTermination();
    }

    static class ExampleServiceImpl extends ExampleServiceGrpc.ExampleServiceImplBase {
        @Override
        public void streamResults(Request request, StreamObserver<Response> responseObserver) {
            String query = request.getQuery();

            // Simulate sending multiple responses back to the client
            for (int i = 0; i < 10; i++) {
                Response response = Response.newBuilder()
                        .setResult("Response " + i + " for query: " + query)
                        .build();

                // Send the response to the client
                responseObserver.onNext(response);

                // Simulate some delay
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // Notify the client that the stream is completed
            responseObserver.onCompleted();
            System.out.println("streamResults completed");
        }
    }
}

