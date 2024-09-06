package com.ServerStreamMaxAge;

import io.grpc.*;

public class MyServerInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call, Metadata headers, ServerCallHandler<ReqT, RespT> next) {

        // Get the default listener for the call
        ServerCall.Listener<ReqT> listener = next.startCall(call, headers);

        // Return a custom listener to handle onCancel
        return new ForwardingServerCallListener.SimpleForwardingServerCallListener<ReqT>(listener) {
            @Override
            public void onCancel() {
                super.onCancel(); // Call the base implementation
                // Handle the cancellation logic here
                System.out.println("Call canceled by client or server due to max connection age.");
            }
        };
    }
}
