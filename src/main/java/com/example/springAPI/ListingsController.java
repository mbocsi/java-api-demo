package com.example.springAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @CrossOrigin(origins = "*")
    @GetMapping("")
    public ResponseEntity<ListingsResponse> listings() {
        ListingsResponse response = new ListingsResponse();
        HttpHeaders responseHeaders = new HttpHeaders();
        for(Listing listing: this.data) {
            response.appendListing(listing);
        }
        return new ResponseEntity<>(response, responseHeaders, HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("")
    public ResponseEntity<ListingResponse> newListing(@RequestBody Listing listing) {
        Random rand = new Random();
        int id = rand.nextInt(10000);
        Listing newListing = new Listing(id, listing.userId(), listing.name(), listing.askingPrice());
        this.data.add(newListing);

        HttpHeaders responseHeaders = new HttpHeaders();
        return new ResponseEntity<>(new ListingResponse(true, newListing), responseHeaders, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public ResponseEntity<ListingResponse> listing(@PathVariable("id") long id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        for(Listing l: this.data){
            if(l.id() == id) {
                return new ResponseEntity<>(new ListingResponse(true, l), responseHeaders, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(responseHeaders, HttpStatus.NOT_FOUND);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<ListingResponse> replaceListing(@RequestBody Listing listing, @PathVariable long id) {
        HttpHeaders responseHeaders = new HttpHeaders();
        Listing newListing = new Listing(id, listing.userId(), listing.name(), listing.askingPrice());

        for(int i = 0; i < this.data.size(); i++) {
            if(this.data.get(i).id() == id) {
                this.data.set(i, newListing);
                return new ResponseEntity<>(new ListingResponse(true, newListing), responseHeaders, HttpStatus.OK);
            }
        }
        this.data.add(newListing);
        return new ResponseEntity<>(new ListingResponse(true, newListing), responseHeaders, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteListing(@PathVariable long id) {
        HttpHeaders responseHeaders = new HttpHeaders();

        for(int i = 0; i < this.data.size(); i++) {
            if(this.data.get(i).id() == id){
                this.data.remove(i);
                return new ResponseEntity<>(responseHeaders, HttpStatus.NO_CONTENT);
            }
        }

        return new ResponseEntity<>(responseHeaders, HttpStatus.NOT_FOUND);
    }
}
