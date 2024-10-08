package com.grpc;

import com.grpc.Config.HelloReply;
import com.grpc.Config.HelloRequest;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class GrpcClient {

    public static void main(String[] args) {

        /* *
         * Establish a connection to the server using the class ManagedChannelBuilder and the function usePlaintext().
         * The function usePlainText() should only be used for testing or for APIs where the use of such API or the data
         * exchanged is not sensitive.
         * */
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8081).usePlaintext().build();

        /* *
         * A blocking-style stub instance of Greeter service. We can have two types of stubs: blocking and async.
         * Blocking stubs are synchronous. Non-blocking stubs are asynchronous.
         * Take care if you want to call an RPC function on a blocking stub from UI thread
         * (cause an unresponsive/laggy UI).
         * */

        GreeterGrpc.GreeterBlockingStub bookStub = GreeterGrpc.newBlockingStub(channel);

        /* *
         * An asynchronous instance of the above declaration.
         * GreeterGrpc.GreeterStub bookStub = GreeterGrpc.newStub(channel);
         * */

        /* *
         * We can now use the gRPC function via our instance of GreeterBlockingStub bookStub.
         * Below we call the function sayHello(Helloworld.HelloRequest request) with name field value set to "gRPC".
         * This function returns a value of type  Helloworld.HelloReply that is saved in our instance reply.
         * We can get via generated functions every field from our message, in this example, we have just one field.
         * */
        HelloReply reply = bookStub.sayHello(HelloRequest.newBuilder().setName("gRPC").build());
        System.out.println(reply.getMessage());

       /* Iterator<HelloReply> reply1 = bookStub.sayHelloServerStream(HelloRequest.newBuilder().setName("gRPCServerStream").build());
        if(reply1.hasNext()){
            System.out.println(reply1.hashCode());
        }*/

        channel.shutdown();

    }

}
