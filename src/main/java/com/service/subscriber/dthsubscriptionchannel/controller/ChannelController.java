package com.service.subscriber.dthsubscriptionchannel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.service.subscriber.dthsubscriptionchannel.model.Channels;
import com.service.subscriber.dthsubscriptionchannel.repository.ChannelRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class ChannelController {
	@Autowired
	ChannelRepository channelrepo;

	
	/**
	 * Add new channel
	 * @param channel
	 * @return
	 */
	@PostMapping("/addChannel")
	public ResponseEntity<Channels> AddChannel(@RequestBody Channels channel) {
		channelrepo.save(channel);
		log.info("channel details are added ");
		return ResponseEntity.status(HttpStatus.OK).body(channel);
	}
}
