package com.fr.test.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SupplierConfig {
	
	@Value("#{configProperties['LH.systemIdentity']}")
	private String systemIdentity;
	
	@Value("#{configProperties['LH.systemIdentityPassword']}")
	private String password;
	
	@Value("${LH.PseudoCityCode}")
	private String pseudoCityCode;
	
	
	public SupplierConfig() {
		// TODO Auto-generated constructor stub
	}

	public String getPseudoCityCode() {
		return pseudoCityCode;
	}

	public void setPseudoCityCode(String pseudoCityCode) {
		this.pseudoCityCode = pseudoCityCode;
	}

	public String getSystemIdentity() {
		return systemIdentity;
	}

	public void setSystemIdentity(String systemIdentity) {
		this.systemIdentity = systemIdentity;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
