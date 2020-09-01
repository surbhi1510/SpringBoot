package com.service.subscriber.dthsubscriptionchannel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.subscriber.dthsubscriptionchannel.model.Subscriber;
import com.service.subscriber.dthsubscriptionchannel.model.SubscriberDetails;
import com.service.subscriber.dthsubscriptionchannel.service.SubscriberService;

import lombok.extern.slf4j.Slf4j;

/**
 * Subscriber controller
 *
 */
@RestController
@Slf4j
public class SubscriberController {
	@Autowired
	SubscriberService subscriberService;

	/**
	 * @param subscriber
	 * @return
	 */
	@PostMapping("/addSubscription")
	public ResponseEntity<Subscriber> addSubscriber(@Valid @RequestBody Subscriber subscriber) {

		Subscriber subscribers = subscriberService.addSubscriber(subscriber);
		log.info("Adding a new subscriber");
		return ResponseEntity.status(HttpStatus.OK).body(subscribers);

	}

	
	/**
	 * @param subscriber
	 * @return
	 */
	@DeleteMapping("/editSubscription/{subscribers_id}/{channel_id}")
	public ResponseEntity<String> editSubscription(@Valid @PathVariable("subscribers_id") long subscribers_id,@Valid @PathVariable("channel_id") int channel_id) { 
		String message = subscriberService.editSubscription(subscribers_id,channel_id);
		log.info("Unsubscribing a user");
		return ResponseEntity.status(HttpStatus.OK).body(message);

	}
	@GetMapping("/viewSubscription/{subscribers_id}")
	public ResponseEntity<SubscriberDetails> viewSubscriber(@Valid @PathVariable("subscribers_id") long subscribers_id) {

		SubscriberDetails subscribers = subscriberService.viewSubscriber(subscribers_id);
		log.info("subscription details for the given subscriber id");
		return ResponseEntity.status(HttpStatus.OK).body(subscribers);

	}
}
