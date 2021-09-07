package com.java.mathew.gateway;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class GatewayFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
System.out.println("Pre Processing Logic Goes Here: "+exchange.getRequest().getBody());
		return chain.filter(exchange).then(Mono.fromRunnable(()->{
			System.out.println("Post Processing Logic Goes Here: "+exchange.getResponse().getStatusCode());
		}));
	}

}
