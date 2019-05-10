package com.lovnx;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.lovnx.filter.ErrorFilter;
import com.lovnx.filter.FirstFilter;
import com.lovnx.filter.ResultFilter;
import com.lovnx.filter.SecondFilter;
import com.marcosbarbero.zuul.filters.pre.ratelimit.RateLimitFilter;

@EnableZuulProxy
@SpringCloudApplication
public class ZuulApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulApplication.class).web(true).run(args);
	}

	@Bean
	public FirstFilter accessFilter() {
		return new FirstFilter();
	}
	
	@Bean
	public RateLimitFilter rateLimiterFilter() {
		return new RateLimitFilter(null, null, null);
	}
	
	@Bean
	public ResultFilter resultFilter() {
		return new ResultFilter();
	}
	
	@Bean
	public SecondFilter uuidFilter() {
		return new SecondFilter();
	}
	
	@Bean
	public ErrorFilter validateFilter() {
		return new ErrorFilter();
	}
	
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

}
