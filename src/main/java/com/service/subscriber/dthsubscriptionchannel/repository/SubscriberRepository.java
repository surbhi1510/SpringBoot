package com.service.subscriber.dthsubscriptionchannel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.subscriber.dthsubscriptionchannel.model.Subscriber;
@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {

	/**
	 * Returns the subscriber details for given channel and subscriber id.
	 * @param subscribers_id
	 * @param channel_id
	 * @return
	 */
	@Query("select subscriber from Subscriber subscriber where subscriber.subscribers_id = :subscribers_id and subscriber.channel_id = :channel_id")
	public Subscriber findBysubscribers_idAndchannel_id(@Param("subscribers_id")long subscribers_id,@Param("channel_id") int channel_id);
	
	/**
	 * Returns list containing channel subscribed by the user.
	 * @param subscribers_id
	 * @return
	 */
	@Query("select subscriber.channel_id  from Subscriber subscriber where subscriber.subscribers_id = :subscribers_id")
	public List<Integer> findChannelIds(@Param("subscribers_id") long subscribers_id);
}
