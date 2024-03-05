package com.ashish.service;

import com.ashish.Greeter;
import com.ashish.HelloReply;
import com.ashish.HelloRequest;
import com.ashish.resources.CxfClientRestResource;

import io.quarkus.grpc.GrpcService;
import io.smallrye.mutiny.Uni;

@GrpcService
public class HelloGrpcService  implements Greeter{
	
	@Override
	public Uni<HelloReply> sayHello(HelloRequest request) {
		CxfClientRestResource resource = new CxfClientRestResource();
		String response = resource.soapCall(request.getName());
		return Uni.createFrom().item(() ->
        HelloReply.newBuilder().setMessage("Hello " + response).build()
        );
	}
}
