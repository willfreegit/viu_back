package com.viu.moduloautenticacion.Parqueadero.model;

import com.viu.moduloautenticacion.Cost.Model.Cost;
import com.viu.moduloautenticacion.Lote.model.Lot;
import com.viu.moduloautenticacion.Usuario.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Parking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_parking;
    private String name;
    private String address;
    private String longitude;
    private String latitude;
    private String attention;
    private String state;

    @OneToMany
    private Set<User> users;
    @OneToMany
    private Set<Lot> lots;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Cost> costs;

    public long getId_parking() {
        return id_parking;
    }

    public void setId_parking(long id_parking) {
        this.id_parking = id_parking;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Lot> getLots() {
        return lots;
    }

    public void setLots(Set<Lot> lots) {
        this.lots = lots;
    }

    public Set<Cost> getCosts() {
        return costs;
    }

    public void setCosts(Set<Cost> costs) {
        this.costs = costs;
        costs.forEach(cost -> cost.setParking(this));
    }
}
