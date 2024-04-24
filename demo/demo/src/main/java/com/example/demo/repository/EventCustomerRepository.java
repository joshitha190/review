package com.example.demo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Event;
import com.example.demo.model.EventCustomer;

@Repository
public interface EventCustomerRepository extends JpaRepository<EventCustomer,Integer>{
 
    @Query(value="SELECT o FROM Orderss o where o.userId> ?1")
   List<EventCustomer> findByUse(int u);

   @Modifying
   @Query(value="UPDATE Orderss o SET user_id= :val1 WHERE order_id= :val2",nativeQuery = true)
   void updateuse(@Param("val1") int p,@Param("val2")int p1);
}

