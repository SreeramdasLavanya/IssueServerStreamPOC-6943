package com.StreamService;

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
    comments = "Source: StreamService.proto")
public final class StreamServiceGrpc {

  private StreamServiceGrpc() {}

  public static final String SERVICE_NAME = "example.StreamService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.StreamService.StreamServiceOuterClass.StreamRequest,
      com.StreamService.StreamServiceOuterClass.StreamResponse> getStreamDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "streamData",
      requestType = com.StreamService.StreamServiceOuterClass.StreamRequest.class,
      responseType = com.StreamService.StreamServiceOuterClass.StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.StreamService.StreamServiceOuterClass.StreamRequest,
      com.StreamService.StreamServiceOuterClass.StreamResponse> getStreamDataMethod() {
    io.grpc.MethodDescriptor<com.StreamService.StreamServiceOuterClass.StreamRequest, com.StreamService.StreamServiceOuterClass.StreamResponse> getStreamDataMethod;
    if ((getStreamDataMethod = StreamServiceGrpc.getStreamDataMethod) == null) {
      synchronized (StreamServiceGrpc.class) {
        if ((getStreamDataMethod = StreamServiceGrpc.getStreamDataMethod) == null) {
          StreamServiceGrpc.getStreamDataMethod = getStreamDataMethod = 
              io.grpc.MethodDescriptor.<com.StreamService.StreamServiceOuterClass.StreamRequest, com.StreamService.StreamServiceOuterClass.StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "example.StreamService", "streamData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.StreamService.StreamServiceOuterClass.StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.StreamService.StreamServiceOuterClass.StreamResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new StreamServiceMethodDescriptorSupplier("streamData"))
                  .build();
          }
        }
     }
     return getStreamDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StreamServiceStub newStub(io.grpc.Channel channel) {
    return new StreamServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StreamServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new StreamServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StreamServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new StreamServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class StreamServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void streamData(com.StreamService.StreamServiceOuterClass.StreamRequest request,
        io.grpc.stub.StreamObserver<com.StreamService.StreamServiceOuterClass.StreamResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getStreamDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getStreamDataMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                com.StreamService.StreamServiceOuterClass.StreamRequest,
                com.StreamService.StreamServiceOuterClass.StreamResponse>(
                  this, METHODID_STREAM_DATA)))
          .build();
    }
  }

  /**
   */
  public static final class StreamServiceStub extends io.grpc.stub.AbstractStub<StreamServiceStub> {
    private StreamServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreamServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreamServiceStub(channel, callOptions);
    }

    /**
     */
    public void streamData(com.StreamService.StreamServiceOuterClass.StreamRequest request,
        io.grpc.stub.StreamObserver<com.StreamService.StreamServiceOuterClass.StreamResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getStreamDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class StreamServiceBlockingStub extends io.grpc.stub.AbstractStub<StreamServiceBlockingStub> {
    private StreamServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreamServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreamServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.StreamService.StreamServiceOuterClass.StreamResponse> streamData(
        com.StreamService.StreamServiceOuterClass.StreamRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getStreamDataMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StreamServiceFutureStub extends io.grpc.stub.AbstractStub<StreamServiceFutureStub> {
    private StreamServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private StreamServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected StreamServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new StreamServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM_DATA = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StreamServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StreamServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_STREAM_DATA:
          serviceImpl.streamData((com.StreamService.StreamServiceOuterClass.StreamRequest) request,
              (io.grpc.stub.StreamObserver<com.StreamService.StreamServiceOuterClass.StreamResponse>) responseObserver);
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

  private static abstract class StreamServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    StreamServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.StreamService.StreamServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("StreamService");
    }
  }

  private static final class StreamServiceFileDescriptorSupplier
      extends StreamServiceBaseDescriptorSupplier {
    StreamServiceFileDescriptorSupplier() {}
  }

  private static final class StreamServiceMethodDescriptorSupplier
      extends StreamServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    StreamServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (StreamServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new StreamServiceFileDescriptorSupplier())
              .addMethod(getStreamDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
