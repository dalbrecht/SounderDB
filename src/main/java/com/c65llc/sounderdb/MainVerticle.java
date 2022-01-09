package com.c65llc.sounderdb;

import com.c65llc.protos.pingpong;
import com.google.protobuf.Service;
import io.grpc.BindableService;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Promise;
import io.vertx.grpc.VertxServer;
import io.vertx.grpc.VertxServerBuilder;

public class MainVerticle extends AbstractVerticle {

    @Override
    public void start(Promise<Void> startPromise) throws Exception {
        BindableService service = new PingServiceFactory().build();

        VertxServer rpcServer = VertxServerBuilder
                .forAddress(vertx, "0.0.0.0", 8080)
                .addService(service)
                .build();

// Start is asynchronous
        rpcServer.start();
    }
}