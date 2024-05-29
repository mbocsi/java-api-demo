package com.example.springAPI;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/listings")
public class ListingsController {

    private final List<Listing> data;
    public ListingsController() {
        this.data = new ArrayList<Listing>();
        this.data.add(new Listing(2167, "user_6723722", "Office chair", 20.0));
        this.data.add(new Listing(7323, "user_1562722", "ECE 340 Textbook", 22.0));
        this.data.add(new Listing(3425, "user_7865375", "Keyboard", 15.0));
        this.data.add(new Listing(9234, "user_7458744", "Couch", 40.0));
        this.data.add(new Listing(2562, "user_9345643", "Plates", 12.5));
    }

    @GetMapping("")
    public ResponseEntity<ListingsResponse> listings() {
        ListingsResponse response = new ListingsResponse();
        for(Listing listing: this.data) {
            response.appendListing(listing);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Listing> listing(@PathVariable("id") long id) {
        for(Listing l: this.data){
            if(l.id() == id) {
                return new ResponseEntity<>(l, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
