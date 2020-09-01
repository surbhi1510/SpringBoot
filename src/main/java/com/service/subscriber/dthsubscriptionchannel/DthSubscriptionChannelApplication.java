package com.service.subscriber.dthsubscriptionchannel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * DTH application
 *
 */
@EnableJpaRepositories(basePackages = "com.service.subscriber.dthsubscriptionchannel.repository")
@SpringBootApplication
@EnableTransactionManagement
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class DthSubscriptionChannelApplication {
	
	@Configuration
	static class OktaOauth2WebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
					.authorizeRequests().anyRequest().authenticated()
					.and()
					.oauth2ResourceServer().jwt();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(DthSubscriptionChannelApplication.class, args);
	}

}
