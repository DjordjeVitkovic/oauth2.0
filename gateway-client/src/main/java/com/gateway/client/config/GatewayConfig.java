package com.gateway.client.config;

//@Configuration
//public class GatewayConfig {
//
//  @Bean
//  public RouteLocator routeLocator(RouteLocatorBuilder builder) {
//    return builder.routes()
//      .route(r ->
//        r.path("/resource/**")
//          .filters(
//            f ->
//              f.rewritePath("/resource/", "/")
//                .tokenRelay()
//          )
//          .uri("http://localhost:8082")
//      )
//      .build();
//  }
//
//}
