package com.c65llc.sounderdb;
import com.c65llc.protos.GreeterGrpc;
import com.c65llc.protos.Ping;
import com.c65llc.protos.Pong;
import io.grpc.BindableService;
import io.grpc.stub.StreamObserver;


public class PingServiceFactory {
    public static void init(){

    }
    public BindableService build() {
        return new GreeterGrpc.GreeterImplBase() {
            @Override
            public void ping(Ping request, StreamObserver<Pong> responseObserver) {
                responseObserver.onNext(
                    Pong.newBuilder().setName(request.getName()).build()
                 );
                responseObserver.onCompleted();
            }
        };
    }
}
