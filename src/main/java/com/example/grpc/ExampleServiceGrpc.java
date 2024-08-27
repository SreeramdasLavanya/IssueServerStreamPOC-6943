package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Define the service with a server streaming RPC
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: StreamExample.proto")
public final class ExampleServiceGrpc {

  private ExampleServiceGrpc() {}

  public static final String SERVICE_NAME = "streamexample.ExampleService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.StreamExampleProto.Request,
      com.example.grpc.StreamExampleProto.Response> getStreamResultsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamResults",
      requestType = com.example.grpc.StreamExampleProto.Request.class,
      responseType = com.example.grpc.StreamExampleProto.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.StreamExampleProto.Request,
      com.example.grpc.StreamExampleProto.Response> getStreamResultsMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.StreamExampleProto.Request, com.example.grpc.StreamExampleProto.Response> getStreamResultsMethod;
    if ((getStreamResultsMethod = ExampleServiceGrpc.getStreamResultsMethod) == null) {
      synchronized (ExampleServiceGrpc.class) {
        if ((getStreamResultsMethod = ExampleServiceGrpc.getStreamResultsMethod) == null) {
          ExampleServiceGrpc.getStreamResultsMethod = getStreamResultsMethod = 
              io.grpc.MethodDescriptor.<com.example.grpc.StreamExampleProto.Request, com.example.grpc.StreamExampleProto.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "streamexample.ExampleService", "StreamResults"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StreamExampleProto.Request.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.grpc.StreamExampleProto.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new ExampleServiceMethodDescriptorSupplier("StreamResults"))
                  .build();
          }
        }
     }
     return getStreamResultsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExampleServiceStub newStub(io.grpc.Channel channel) {
    return new ExampleServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExampleServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ExampleServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExampleServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ExampleServiceFutureStub(channel);
  }

  /**
   * <pre>
   * Define the service with a server streaming RPC
   * </pre>
   */
  public static abstract class ExampleServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void streamResults(com.example.grpc.StreamExampleProto.Request request,
        io.grpc.stub.StreamObserver<com.example.grpc.StreamExampleProto.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamResultsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamResultsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.example.grpc.StreamExampleProto.Request,
                com.example.grpc.StreamExampleProto.Response>(
                  this, METHODID_STREAM_RESULTS)))
          .build();
    }
  }

  /**
   * <pre>
   * Define the service with a server streaming RPC
   * </pre>
   */
  public static final class ExampleServiceStub extends io.grpc.stub.AbstractStub<ExampleServiceStub> {
    private ExampleServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExampleServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExampleServiceStub(channel, callOptions);
    }

    /**
     */
    public void streamResults(com.example.grpc.StreamExampleProto.Request request,
        io.grpc.stub.StreamObserver<com.example.grpc.StreamExampleProto.Response> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamResultsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * Define the service with a server streaming RPC
   * </pre>
   */
  public static final class ExampleServiceBlockingStub extends io.grpc.stub.AbstractStub<ExampleServiceBlockingStub> {
    private ExampleServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExampleServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExampleServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.example.grpc.StreamExampleProto.Response> streamResults(
        com.example.grpc.StreamExampleProto.Request request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamResultsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Define the service with a server streaming RPC
   * </pre>
   */
  public static final class ExampleServiceFutureStub extends io.grpc.stub.AbstractStub<ExampleServiceFutureStub> {
    private ExampleServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ExampleServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ExampleServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM_RESULTS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExampleServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExampleServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_RESULTS:
          serviceImpl.streamResults((com.example.grpc.StreamExampleProto.Request) request,
              (io.grpc.stub.StreamObserver<com.example.grpc.StreamExampleProto.Response>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ExampleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExampleServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.grpc.StreamExampleProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ExampleService");
    }
  }

  private static final class ExampleServiceFileDescriptorSupplier
      extends ExampleServiceBaseDescriptorSupplier {
    ExampleServiceFileDescriptorSupplier() {}
  }

  private static final class ExampleServiceMethodDescriptorSupplier
      extends ExampleServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExampleServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ExampleServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExampleServiceFileDescriptorSupplier())
              .addMethod(getStreamResultsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
