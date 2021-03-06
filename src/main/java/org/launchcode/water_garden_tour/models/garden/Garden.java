package org.launchcode.water_garden_tour.models.garden;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.launchcode.water_garden_tour.models.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Garden extends AbstractEntity {

    @NotBlank(message = "Name is required.")
    @Size(max = 100, message = "Exceeds maximum space allowed.")
    private String name;

    @NotBlank(message="Garden must have an address.")
    private String address;

    @NotBlank(message = "Latitude is required.")
    private String latitude;

    @NotBlank(message = "Longitude is required.")
    private String longitude;

    @NotBlank(message="Description is required.")
    @Size(max=2000, message="Description exceeds maximum number of characters")
    private String description;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    @NotNull(message = "Please select an owner.")
    private Owner owner;

    @ManyToMany
    @JsonIgnore
    @Size(min =1, message = "You must select at least one feature.")
    private List<Feature> features = new ArrayList<>();

    @Lob
    private byte[] image;

    @ManyToMany(mappedBy = "gardens")
    private List<User> users = new ArrayList<>();

    public Garden(String name, String address, String latitude, String longitude, String description, Owner owner, List<Feature> features, byte[] image, List<User> users) throws IOException {
        this();
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.owner = owner;
        this.features = features;
        this.image = image;
        this.users = users;
    }

    public Garden() {
        super();
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return name;
    }

}
