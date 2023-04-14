package elements;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class License implements Serializable, Comparable<License> {
    private List<License> extent = new ArrayList<>();
    private String authority;
    private int id;
    private String type;
    private LocalDate expiration;

    public License(String authority, int id, String type, LocalDate expiration){
        this.authority = authority;
        this.id = id;
        this.type = type;
        this.expiration = expiration;

        addToExtent(this);
    }

    private void addToExtent(License license) {
        extent.add(license);
    }

    // getter for the extent field
    public List<License> getExtent() {
        return extent;
    }

    @Override
    public int compareTo(License other) {
        return this.expiration.compareTo(other.expiration);
    }

    public boolean isValid(){
        LocalDate now = LocalDate.now();
        return ! now.isAfter(expiration);
    }

    public void setExtent(List<License> extent) {
        this.extent = extent;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getExpiration() {
        return expiration;
    }

    public void setExpiration(LocalDate expiration) {
        this.expiration = expiration;
    }

    public void extendValidity(int days){
        expiration = expiration.plusDays(days);
    }

    @Override
    public String toString(){
        return "This License is issued by: " + this.authority + " with license no: " + this.id + " type: " + this.type + " valid until: " + this.expiration + ".";
    }

}

