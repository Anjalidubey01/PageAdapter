package com.example.android.crimedetail;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Model {

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("location_type")
    @Expose
    private String locationType;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("context")
    @Expose
    private String context;
    @SerializedName("outcome_status")
    @Expose
    private OutcomeStatus outcomeStatus;
    @SerializedName("persistent_id")
    @Expose
    private String persistentId;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("location_subtype")
    @Expose
    private String locationSubtype;
    @SerializedName("month")
    @Expose
    private String month;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public OutcomeStatus getOutcomeStatus() {
        return outcomeStatus;
    }

    public void setOutcomeStatus(OutcomeStatus outcomeStatus) {
        this.outcomeStatus = outcomeStatus;
    }

    public String getPersistentId() {
        return persistentId;
    }

    public void setPersistentId(String persistentId) {
        this.persistentId = persistentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationSubtype() {
        return locationSubtype;
    }

    public void setLocationSubtype(String locationSubtype) {
        this.locationSubtype = locationSubtype;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

}
