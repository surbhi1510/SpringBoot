package com.service.subscriber.dthsubscriptionchannel.model;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter

@ToString
@Table(name = "Subscription_Channel")
public class Subscriber {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	@NotNull
	@Digits(fraction = 0, integer = 10)
	private long subscribers_id;
	@NotNull
	@DateTimeFormat(pattern = "yyyy/mm/dd")
	@PastOrPresent(message="date cant be a future date")
	private Date subscription_date;
	@NotNull
	@Digits(fraction = 0, integer = 3)
	private int channel_id;

}
