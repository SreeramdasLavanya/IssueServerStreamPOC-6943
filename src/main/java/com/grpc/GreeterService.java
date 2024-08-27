package com.grpc;

import com.grpc.Config.HelloRequest;
import com.grpc.Config.HelloReply;
import com.grpc.GreeterGrpc.GreeterImplBase;
import io.grpc.stub.StreamObserver;


public class GreeterService extends GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {

        System.out.println("**************" + request.getName());

        HelloReply hr = HelloReply.newBuilder().setMessage("Hello How are you").build();

        responseObserver.onNext(hr);
        responseObserver.onCompleted();
    }



}
