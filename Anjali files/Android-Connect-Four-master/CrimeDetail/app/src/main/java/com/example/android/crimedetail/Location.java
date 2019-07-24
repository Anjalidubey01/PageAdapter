package com.example.android.crimedetail;

 import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

    public class Location {

        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("street")
        @Expose
        private Street street;
        @SerializedName("longitude")
        @Expose
        private String longitude;

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public Street getStreet() {
            return street;
        }

        public void setStreet(Street street) {
            this.street = street;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

    }

