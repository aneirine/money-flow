package com.aneirine.transactionservice.config;

import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LocalRibbonClientConfiguration {

    @Bean
    public ServerList<Server> ribbonServerList() {
        // return new ConfigurationBasedServerList();
        StaticServerList<Server> staticServerList = new StaticServerList<>((new Server("localhost", 9081)),
                new Server("localhost", 8000),
                new Server("localhost", 9082));
        return staticServerList;
    }

}
