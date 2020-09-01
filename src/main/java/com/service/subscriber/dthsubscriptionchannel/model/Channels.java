package com.service.subscriber.dthsubscriptionchannel.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name="channels")
public class Channels {
	
	@Id
	private int channel_id;
	
	private String channel_name;
	
	private double cost_per_month;
	
	
}
