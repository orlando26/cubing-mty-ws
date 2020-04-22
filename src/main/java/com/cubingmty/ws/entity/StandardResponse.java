package com.cubingmty.ws.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor 
public class StandardResponse<T> {
	
	private String status;
	
	private String responsetext;
	
	private T entity;

	public StandardResponse(String status, String responsetext, T entity) {
		super();
		this.status = status;
		this.responsetext = responsetext;
		this.entity = entity;
	}
	
	
	
	
}
