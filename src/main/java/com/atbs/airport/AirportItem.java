package com.atbs.airport;

public class AirportItem {
    private Long id;
    private String name;
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Airport getEntity(){
        Airport airport = new Airport();
        airport.setId(this.id);
        airport.setName(this.name);
        airport.setLocation(this.location);

        return  airport;
    }
}
