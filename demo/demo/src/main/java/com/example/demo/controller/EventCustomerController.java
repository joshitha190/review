package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Event;
import com.example.demo.model.EventCustomer;
import com.example.demo.service.EventCustomerService;
import com.example.demo.service.EventService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController



@RequestMapping("/eventcustomer")

public class EventCustomerController {

    @Autowired
    private EventCustomerService eventCustomerService;

    @GetMapping("/getinfo/{id}")
   

    @PostMapping("/insertt") 
    public String Method(@RequestBody EventCustomer eventc){
        EventCustomer createdEvent = eventCustomerService.createEvent(eventc);
        return "saved";
    }

    @DeleteMapping("d/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") int eventId){
        eventCustomerService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("u/{id}")
    public String updateEvent(@PathVariable("id") int eventId, @RequestBody Event updaEvent){
    EventCustomer exEvent = eventCustomerService.checkEvent(eventId);
    if(exEvent!=null)
    {
         exEvent.setName(updaEvent.getName());
         exEvent.setLocation(updaEvent.getLocation());
         eventCustomerService.createEvent(exEvent);
    }
    else
    return "no data found";
    return "updated";
    }
    @GetMapping("/page/{pn}/{s}")//should use requestparamss instead
    public Page<EventCustomer> pagenatedisplay(@PathVariable("pn") int pn, @PathVariable("s") int s)
    {
      return eventCustomerService.pagenateList(pn, s);
    }

    //pagenation with only contents
    @GetMapping("/pages/{pn}/{s}")//should use requestparamss instead
    public List<EventCustomer> pagenatedisplaycon(@PathVariable("pn") int pn, @PathVariable("s") int s)
    {
         return eventCustomerService.pagenateListcon(pn, s);
    }

    // pagenation with sort and all details
    @GetMapping("/pagess/{pn}/{s}/{st}")//should use requestparamss instead
    public Page<EventCustomer> pagenatedisplaycon(@PathVariable("pn") int pn, @PathVariable("s") int s,@PathVariable("st") String st)
    {
         return eventCustomerService.pageListsort(pn,s,st);
}
//updation using jpql
@PutMapping("putuse/od/{i}/{y}")
public String putuse(@PathVariable int i,@PathVariable int y) {
  eventCustomerService.update(i,y);
  return "updated";
    }

//get userrow by id using jpql
@GetMapping("/guser/{u}")
public List<EventCustomer> getg(@PathVariable int u) {
    return eventCustomerService.getuserIddd(u);
}
}