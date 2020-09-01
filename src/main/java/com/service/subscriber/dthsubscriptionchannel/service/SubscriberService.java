package com.service.subscriber.dthsubscriptionchannel.service;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.subscriber.dthsubscriptionchannel.exception.DataNotValidException;
import com.service.subscriber.dthsubscriptionchannel.exception.RecordNotFoundException;
import com.service.subscriber.dthsubscriptionchannel.model.Subscriber;
import com.service.subscriber.dthsubscriptionchannel.model.SubscriberDetails;
import com.service.subscriber.dthsubscriptionchannel.repository.ChannelRepository;
import com.service.subscriber.dthsubscriptionchannel.repository.CustomerRepository;
import com.service.subscriber.dthsubscriptionchannel.repository.SubscriberRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SubscriberService {
	@Autowired
	SubscriberRepository subscriberRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	ChannelRepository channelRepository;

	/**
	 * Adds a new subscriber to the database.
	 * 
	 * @param subscriber
	 * @return
	 */
	public Subscriber addSubscriber(Subscriber subscriber) {

		boolean exists = subscriberRepository.existsById(subscriber.getId());
		if (exists) {
			throw new DataNotValidException("Id already exists: " + subscriber.getId());
		}
		List<Integer> channels = subscriberRepository.findChannelIds(subscriber.getSubscribers_id());
		if (channels.contains(subscriber.getChannel_id())) {
			throw new DataNotValidException(
					"The channel is already subscribed by this user.Try subscribing for other channels.Subscriber ID: "
							+ subscriber.getSubscribers_id());
		}
		if(!channelRepository.existsById(subscriber.getChannel_id())){
			throw new RecordNotFoundException("No channels found with the entered Id :"+subscriber.getChannel_id());
		}
		return subscriberRepository.save(subscriber);
	}

	/**
	 * Remove a subscriber from the database.
	 * 
	 * @param subscribers_id
	 * @param channel_id
	 * @return
	 */
	public String editSubscription(long subscribers_id, int channel_id) {

		Subscriber findSubscriber = subscriberRepository.findBysubscribers_idAndchannel_id(subscribers_id, channel_id);
		if (findSubscriber == null) {
			throw new RecordNotFoundException(
					"No record found for this subscriber with the given channel id : " + subscribers_id);
		}
		subscriberRepository.delete(findSubscriber);
		return "You have successfully unsubscribed this channel";
	}

	/**
	 * View the subscription details by providing subscriber Id.
	 * 
	 * @param subscribers_id
	 * @return
	 */
	public SubscriberDetails viewSubscriber(@Valid long subscribers_id) {

		SubscriberDetails subscriberdetails = new SubscriberDetails();
		Double finalPrice = 0.0d;
		
		List<String> Name = customerRepository.findCustomerName(subscribers_id);
		String customername = String.join(" ", Name);
		log.info("Name of subscription", Name);
		
		List<Integer> channels = subscriberRepository.findChannelIds(subscribers_id);
		List<String> channelName = new ArrayList<>();
		List<Double> cost = new ArrayList<>();
        if(!channels.isEmpty()){
		log.info("channels", channels.toString());

		

		for (Integer channel_id : channels) {
			channelName.addAll(channelRepository.findChannelName(channel_id));
		}
		log.info("channel name retrieved", channelName.toString());

		
		for (Integer channel_id : channels) {
			cost.addAll(channelRepository.findCostperChannel(channel_id));
		}

		log.info("cost per channel subscription", cost.toString());

		finalPrice = cost.stream().mapToDouble(i -> i).sum();
        }
        finalPrice=finalPrice+100.0;
        
		System.out.println("total cost of channel subscription " + finalPrice);
		log.info("total cost of channel subscription", finalPrice);

		subscriberdetails.setCustomerName(customername);
		subscriberdetails.setSubscriberId(subscribers_id);
		subscriberdetails.setChannelName(channelName);
		subscriberdetails.setTotalprice(finalPrice);
		subscriberdetails.setCost_per_month(cost);

		return subscriberdetails;
	}

}
