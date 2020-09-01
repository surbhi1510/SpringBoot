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
@Table(name = "customers")
public class Customers {
	@Id
	private long subscribers_id;
	private long registered_Number;

	private String first_name;

	private String last_name;

		
}