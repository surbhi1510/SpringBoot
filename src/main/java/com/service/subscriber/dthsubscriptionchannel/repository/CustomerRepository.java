package com.service.subscriber.dthsubscriptionchannel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.service.subscriber.dthsubscriptionchannel.model.Customers;
@Repository
public interface CustomerRepository extends JpaRepository<Customers,Long>  {
	
	/**
	 * find customer name if subscriber id is provided.
	 * @param subscribers_id
	 * @return
	 */
	@Query("select customerobj.first_name,customerobj.last_name  from Customers customerobj where customerobj.subscribers_id = :subscribers_id")
	public List<String> findCustomerName(@Param("subscribers_id") long subscribers_id);

	
	

}
