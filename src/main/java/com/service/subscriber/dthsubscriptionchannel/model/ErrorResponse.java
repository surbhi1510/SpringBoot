package com.service.subscriber.dthsubscriptionchannel.model;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class ErrorResponse {

	public ErrorResponse(String message, List<String> details) {
		super();
		this.message = message;
		this.details = details;
	}

	private String message;

	private List<String> details;

}
