package com.ashish;

import static com.ashish.GreeterGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: hello.proto")
public final class MutinyGreeterGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinyGreeterGrpc() {
    }

    public static MutinyGreeterStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyGreeterStub(channel);
    }

    public static class MutinyGreeterStub extends io.grpc.stub.AbstractStub<MutinyGreeterStub> implements io.quarkus.grpc.MutinyStub {

        private GreeterGrpc.GreeterStub delegateStub;

        private MutinyGreeterStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = GreeterGrpc.newStub(channel);
        }

        private MutinyGreeterStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = GreeterGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyGreeterStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyGreeterStub(channel, callOptions);
        }

        public io.smallrye.mutiny.Uni<com.ashish.HelloReply> sayHello(com.ashish.HelloRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::sayHello);
        }
    }

    public static abstract class GreeterImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public GreeterImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        public io.smallrye.mutiny.Uni<com.ashish.HelloReply> sayHello(com.ashish.HelloRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(com.ashish.GreeterGrpc.getSayHelloMethod(), asyncUnaryCall(new MethodHandlers<com.ashish.HelloRequest, com.ashish.HelloReply>(this, METHODID_SAY_HELLO, compression))).build();
        }
    }

    private static final int METHODID_SAY_HELLO = 0;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>, io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final GreeterImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(GreeterImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                case METHODID_SAY_HELLO:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.ashish.HelloRequest) request, (io.grpc.stub.StreamObserver<com.ashish.HelloReply>) responseObserver, compression, serviceImpl::sayHello);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }
}
