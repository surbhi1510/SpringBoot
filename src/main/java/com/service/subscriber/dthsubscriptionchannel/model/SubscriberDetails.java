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
public class SubscriberDetails {
	
	private String CustomerName;
	private List<String> ChannelName;
	public double totalprice;
	private List<Double> cost_per_month;
	private long SubscriberId;

}
