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
    private long par_code;
    private String par_name;
    private String par_address;
    private String par_longitude;
    private String par_latitude;
    private String par_state;

    @OneToMany
    private Set<User> users;
    @OneToMany
    private Set<Lot> lots;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Cost> costs;

    public long getPar_code() {
        return par_code;
    }

    public void setPar_code(long par_code) {
        this.par_code = par_code;
    }

    public String getPar_name() {
        return par_name;
    }

    public void setPar_name(String par_name) {
        this.par_name = par_name;
    }

    public String getPar_address() {
        return par_address;
    }

    public void setPar_address(String par_address) {
        this.par_address = par_address;
    }

    public String getPar_longitude() {
        return par_longitude;
    }

    public void setPar_longitude(String par_longitude) {
        this.par_longitude = par_longitude;
    }

    public String getPar_latitude() {
        return par_latitude;
    }

    public void setPar_latitude(String par_latitude) {
        this.par_latitude = par_latitude;
    }

    public String getPar_state() {
        return par_state;
    }

    public void setPar_state(String par_state) {
        this.par_state = par_state;
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
