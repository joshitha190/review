package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Event;
import java.util.List;




@Repository
public interface EventRepository extends JpaRepository<Event,Integer>{
  @Query("select e  from Event e where e.location in(?1,?2,?3)")
  List<Event> findByLocation(String l1,String l2,String l3);
}
