/*package com.service.subscriber.dthsubscriptionchannel.controller;

import static org.junit.Assert.assertEquals;

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
import com.service.subscriber.dthsubscriptionchannel.service.SubscriberService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class SubscriberControllerTest {

	@InjectMocks
	private SubscriberController subscriberController;

	@Mock
	private SubscriberService subscriberService;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void viewSubscriber() throws Exception {
		SubscriberDetails subscriberDetails = new SubscriberDetails();
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
		Mockito.when(subscriberService.viewSubscriber(Mockito.anyLong())).thenReturn(subscriberDetails);
		assertEquals(subscriberDetails, subscriberController.viewSubscriber(1234567890).getBody());
	}

	@Test
	public void editSubscription() throws Exception {

		Mockito.when(subscriberService.editSubscription(Mockito.anyLong(), Mockito.anyInt()))
				.thenReturn("You have successfully unsubscribed this channel");
		assertEquals("You have successfully unsubscribed this channel", subscriberController.editSubscription(1234567890,105).getBody());
	}

	@Test
	public void addSubscriber() throws Exception {
		Subscriber subscriber = new Subscriber();
		subscriber.setChannel_id(105);
		subscriber.setId(1);
		subscriber.setSubscribers_id(1234567890);
		Date date=new Date(8, 24, 2020);
		subscriber.setSubscription_date(date);
		
		Mockito.when(subscriberService.addSubscriber(Mockito.any(Subscriber.class))).thenReturn(subscriber);
		assertEquals(subscriber, subscriberController.addSubscriber(new Subscriber()).getBody());	}

}
*/