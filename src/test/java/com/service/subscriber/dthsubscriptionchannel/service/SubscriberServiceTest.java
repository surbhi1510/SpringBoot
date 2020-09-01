/*package com.service.subscriber.dthsubscriptionchannel.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.service.subscriber.dthsubscriptionchannel.model.Subscriber;
import com.service.subscriber.dthsubscriptionchannel.model.SubscriberDetails;
import com.service.subscriber.dthsubscriptionchannel.repository.SubscriberRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SubscriberServiceTest {

	@InjectMocks
	private SubscriberService subscriberService;

	@Mock
	SubscriberRepository subscriberRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addSubscriber() {
		Subscriber subscriber = new Subscriber();
		subscriber.setChannel_id(105);
		subscriber.setId(1);
		subscriber.setSubscribers_id(1234567890);
		Date date=new Date(8, 24, 2020);
		subscriber.setSubscription_date(date);
		Mockito.when(subscriberRepository.save(subscriber)).thenReturn(subscriber);
	}
	
	@Test
	public void editSubscriber() {
		Subscriber subscriber = new Subscriber();
		subscriber.setChannel_id(105);
		subscriber.setId(1);
		subscriber.setSubscribers_id(1234567890);
		Date date=new Date(8, 24, 2020);
		subscriber.setSubscription_date(date);
		Mockito.when(subscriberRepository.findBysubscribers_idAndchannel_id(subscriber.getSubscribers_id(), subscriber.getChannel_id())).thenReturn(subscriber);
			
	}
	
	@Test
	public void viewSubscriber() {
		SubscriberDetails subscriberDetails = new SubscriberDetails();
		List<Integer> ChannelId= new ArrayList<>();
		ChannelId.add(101);
		ChannelId.add(121);
		ChannelId.add(131);
		ChannelId.add(141);
		ChannelId.add(151);
		List<String> ChannelName = new ArrayList<String>();
		ChannelName.add("star plus");
		ChannelName.add("star movies");
		ChannelName.add("zee tv");
		ChannelName.add("sony");
		ChannelName.add("zoom");
		List<Double> cost_per_month = new ArrayList<>();
		cost_per_month.add(11.00);
		cost_per_month.add(3.00);
		cost_per_month.add(15.00);
		cost_per_month.add(17.00);
		cost_per_month.add(4.00);
		subscriberDetails.setChannelName(ChannelName);
		subscriberDetails.setCost_per_month(cost_per_month);
		subscriberDetails.setSubscriberId(1234567890);
		subscriberDetails.setCustomerName("surbhi sinha");
		subscriberDetails.setTotalprice(150.00);
		Mockito.when(subscriberRepository.findChannelIds(subscriberDetails.getSubscriberId())).thenReturn(ChannelId);
		
			
	}
}
*/