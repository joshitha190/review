package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Event;
import com.example.demo.service.EventService;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/event")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping("/getid/{id}")
    public List<Event> getMethodName(@RequestParam String a,@RequestParam String b,@RequestParam String c){
        return eventService.getall(a,b,c);

    }

    @PostMapping("/ins") 
    public String Method(@RequestBody Event event){
        Event createdEvent = eventService.createEvent(event);
        return "saved";
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEvent(@PathVariable("id") int eventId){
        eventService.deleteEvent(eventId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("update/{id}")
    public String updateEvent(@PathVariable("id") int eventId, @RequestBody Event updaEvent){
    Event exEvent = eventService.checkEvent(eventId);
    if(exEvent!=null)
    {
         exEvent.setName(updaEvent.getName());
         exEvent.setLocation(updaEvent.getLocation());
         eventService.createEvent(exEvent);
    }
    else
    return "no data found";
    return "updated";
    }
// @PostMapping("josh")
// public String postMethodName(@RequestBody Event  event) {
//     //TODO: process POST request
//     Event createdEvent = eventService.createEvent(event);
    
//     return "saved";
// }
// @GetMapping("getid/{id}")
// public Optional <Event> getvalue(@PathVariable int id){
//     return eventService.getEvent(id);
// }
// @PutMapping("getvalue/{id}")
// public String putMethodName(@PathVariable ("id") int eventId, @RequestBody Event updaEvent) {
    
//     Event exEvent=eventService.checkEvent(eventId);
//    if(exEvent!=null)
//    {
//     exEvent.setName(updaEvent.getName());
//     exEvent.setLocation(updaEvent.getLocation());
//     eventService.createEvent(exEvent);
//    }
//    else
//    return "no data found";
//    return "updated";
// }
}









