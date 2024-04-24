package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.model.Event;
import com.example.demo.model.EventCustomer;
import com.example.demo.repository.EventCustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class EventCustomerService {
    @Autowired
    private EventCustomerRepository eventCustomerRepository;
     public EventCustomer saveEve(EventCustomer eventCustomer){
        return eventCustomerRepository.save(eventCustomer);
     }
     public  Page<EventCustomer> pagenateList(int pn,int s)
     { 
       return eventCustomerRepository.findAll(PageRequest.of(pn, s));
     }
      
     //pagenation only content
     public List<EventCustomer> pagenateListcon(int pn,int s)
     {
         return eventCustomerRepository.findAll(PageRequest.of(pn, s)).getContent();
     }
  
     //pagenation and sort
     public Page<EventCustomer> pageListsort(int pn,int s,String st)
     {
       return eventCustomerRepository.findAll(PageRequest.of(pn,s,Sort.by(Direction.ASC,st )));
  }

  public EventCustomer createEvent(EventCustomer event){
   return eventCustomerRepository.save(event);
}

public void deleteEvent(int eventId){
   eventCustomerRepository.deleteById(eventId);
}
public EventCustomer updateEvent(int eventId, EventCustomer eventDetails) {
   EventCustomer event = eventCustomerRepository.findById(eventId)
           .orElse(null);

   event.setName(eventDetails.getName());
 
   // Update other fields as needed

   EventCustomer updatedEvent = eventCustomerRepository.save(event);
   return updatedEvent;
}
public EventCustomer checkEvent(int id)
{
   return eventCustomerRepository.findById(id).orElse(null);
}
public Optional<EventCustomer> getEvent(int id)
{
return eventCustomerRepository.findById(id);
  
}

public List<EventCustomer> getuserIddd(int u)
   {
    return eventCustomerRepository.findByUse(u);
   }

@Transactional
   public void update(int a,int b){
    eventCustomerRepository.updateuse(a,b);
}
}
