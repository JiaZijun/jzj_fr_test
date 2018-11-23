package com.fr.test.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemConfig {
	
	@Value("${mail.to}")
	private String to ;
	
	@Value("${mail.host}")
	private String host ;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	
	

}
