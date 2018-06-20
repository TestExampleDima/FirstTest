package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("total_count")
    public Integer total_count;

    public User(){
    }

    public User(Integer total_count) {
        this.total_count = total_count;

    }

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;

    }

    @Override
    public String toString() {
        return "total_count = " + total_count ;
    }
}