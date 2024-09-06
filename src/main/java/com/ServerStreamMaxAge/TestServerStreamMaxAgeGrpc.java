package com.ServerStreamMaxAge;

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
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: ServerStreamMaxAge.proto")
public final class TestServerStreamMaxAgeGrpc {

  private TestServerStreamMaxAgeGrpc() {}

  public static final String SERVICE_NAME = "TestServerStreamMaxAge";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.ServerStreamMaxAge.ServerStreamMaxAge.Empty,
      com.ServerStreamMaxAge.ServerStreamMaxAge.Response> getStreamDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamData",
      requestType = com.ServerStreamMaxAge.ServerStreamMaxAge.Empty.class,
      responseType = com.ServerStreamMaxAge.ServerStreamMaxAge.Response.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.ServerStreamMaxAge.ServerStreamMaxAge.Empty,
      com.ServerStreamMaxAge.ServerStreamMaxAge.Response> getStreamDataMethod() {
    io.grpc.MethodDescriptor<com.ServerStreamMaxAge.ServerStreamMaxAge.Empty, com.ServerStreamMaxAge.ServerStreamMaxAge.Response> getStreamDataMethod;
    if ((getStreamDataMethod = TestServerStreamMaxAgeGrpc.getStreamDataMethod) == null) {
      synchronized (TestServerStreamMaxAgeGrpc.class) {
        if ((getStreamDataMethod = TestServerStreamMaxAgeGrpc.getStreamDataMethod) == null) {
          TestServerStreamMaxAgeGrpc.getStreamDataMethod = getStreamDataMethod = 
              io.grpc.MethodDescriptor.<com.ServerStreamMaxAge.ServerStreamMaxAge.Empty, com.ServerStreamMaxAge.ServerStreamMaxAge.Response>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "TestServerStreamMaxAge", "StreamData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ServerStreamMaxAge.ServerStreamMaxAge.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.ServerStreamMaxAge.ServerStreamMaxAge.Response.getDefaultInstance()))
                  .setSchemaDescriptor(new TestServerStreamMaxAgeMethodDescriptorSupplier("StreamData"))
                  .build();
          }
        }
     }
     return getStreamDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TestServerStreamMaxAgeStub newStub(io.grpc.Channel channel) {
    return new TestServerStreamMaxAgeStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TestServerStreamMaxAgeBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TestServerStreamMaxAgeBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TestServerStreamMaxAgeFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TestServerStreamMaxAgeFutureStub(channel);
  }

  /**
   */
  public static abstract class TestServerStreamMaxAgeImplBase implements io.grpc.BindableService {

    /**
     */
    public void streamData(com.ServerStreamMaxAge.ServerStreamMaxAge.Empty request,
        io.grpc.stub.StreamObserver<com.ServerStreamMaxAge.ServerStreamMaxAge.Response> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamDataMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.ServerStreamMaxAge.ServerStreamMaxAge.Empty,
                com.ServerStreamMaxAge.ServerStreamMaxAge.Response>(
                  this, METHODID_STREAM_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class TestServerStreamMaxAgeStub extends io.grpc.stub.AbstractStub<TestServerStreamMaxAgeStub> {
    private TestServerStreamMaxAgeStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TestServerStreamMaxAgeStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServerStreamMaxAgeStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TestServerStreamMaxAgeStub(channel, callOptions);
    }

    /**
     */
    public void streamData(com.ServerStreamMaxAge.ServerStreamMaxAge.Empty request,
        io.grpc.stub.StreamObserver<com.ServerStreamMaxAge.ServerStreamMaxAge.Response> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TestServerStreamMaxAgeBlockingStub extends io.grpc.stub.AbstractStub<TestServerStreamMaxAgeBlockingStub> {
    private TestServerStreamMaxAgeBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TestServerStreamMaxAgeBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServerStreamMaxAgeBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TestServerStreamMaxAgeBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.ServerStreamMaxAge.ServerStreamMaxAge.Response> streamData(
        com.ServerStreamMaxAge.ServerStreamMaxAge.Empty request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TestServerStreamMaxAgeFutureStub extends io.grpc.stub.AbstractStub<TestServerStreamMaxAgeFutureStub> {
    private TestServerStreamMaxAgeFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TestServerStreamMaxAgeFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TestServerStreamMaxAgeFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TestServerStreamMaxAgeFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TestServerStreamMaxAgeImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(TestServerStreamMaxAgeImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_DATA:
          serviceImpl.streamData((com.ServerStreamMaxAge.ServerStreamMaxAge.Empty) request,
              (io.grpc.stub.StreamObserver<com.ServerStreamMaxAge.ServerStreamMaxAge.Response>) responseObserver);
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

  private static abstract class TestServerStreamMaxAgeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TestServerStreamMaxAgeBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.ServerStreamMaxAge.ServerStreamMaxAge.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TestServerStreamMaxAge");
    }
  }

  private static final class TestServerStreamMaxAgeFileDescriptorSupplier
      extends TestServerStreamMaxAgeBaseDescriptorSupplier {
    TestServerStreamMaxAgeFileDescriptorSupplier() {}
  }

  private static final class TestServerStreamMaxAgeMethodDescriptorSupplier
      extends TestServerStreamMaxAgeBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    TestServerStreamMaxAgeMethodDescriptorSupplier(String methodName) {
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
      synchronized (TestServerStreamMaxAgeGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TestServerStreamMaxAgeFileDescriptorSupplier())
              .addMethod(getStreamDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
