package com.service.subscriber.dthsubscriptionchannel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.subscriber.dthsubscriptionchannel.model.Channels;

@Repository
public interface ChannelRepository extends JpaRepository<Channels, Integer> {
	
	@Query("select customerobj.channel_name  from Channels customerobj where customerobj.channel_id = :channel_id")
	public List<String> findChannelName(@Param("channel_id") int channel_id);

	@Query("select customerobj.cost_per_month  from Channels customerobj where customerobj.channel_id = :channel_id")
	public List<Double> findCostperChannel(@Param("channel_id") int channel_id);

}
