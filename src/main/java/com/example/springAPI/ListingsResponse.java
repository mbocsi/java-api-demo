package com.example.springAPI;

import java.util.List;
import java.util.ArrayList;

public class ListingsResponse {
    private List<Listing> results;
    private boolean success;
    public ListingsResponse() {
        this.results = new ArrayList<>();
        this.success = true;
    }
    public void appendListing(Listing listing) {
        this.results.add(listing);
    }
    public List<Listing> getListings() {
        return this.results;
    }
    public boolean getSuccess() {
        return this.success;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof ListingsResponse response){
            if(response.getSuccess() != this.success) {
                return false;
            }
            return response.getListings().equals(this.results);
        }
        return false;
    }
}
