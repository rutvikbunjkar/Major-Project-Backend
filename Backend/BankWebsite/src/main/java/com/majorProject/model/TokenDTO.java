
package com.majorProject.model;

import java.util.Date;

public class TokenDTO{
    private int tokenId;

    private Date expectedWaitTime;
    
    private Date tokenGenerationTime;
    private String serviceDescription;
    private String status;

    private int serviceId;

	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public Date getExpectedWaitTime() {
		return expectedWaitTime;
	}

	public void setExpectedWaitTime(Date expectedWaitTime) {
		this.expectedWaitTime = expectedWaitTime;
	}

	public Date getTokenGenerationTime() {
		return tokenGenerationTime;
	}

	public void setTokenGenerationTime(Date tokenGenerationTime) {
		this.tokenGenerationTime = tokenGenerationTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getServiceId() {
		return serviceId;
	}

	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	

    
}

