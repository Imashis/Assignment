package com.ashish;

import io.quarkus.grpc.MutinyService;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: hello.proto")
public interface Greeter extends MutinyService {

    io.smallrye.mutiny.Uni<com.ashish.HelloReply> sayHello(com.ashish.HelloRequest request);
}
