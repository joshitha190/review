package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    private int id;
    private String name;
    private String location;
 
//    @OneToOne 
//    private   EventCustomer eventCustomer;


@OneToMany(mappedBy="event",cascade=CascadeType.All)
@JsonManagedReference
private List<EventCustomer> eventCustomer;
}