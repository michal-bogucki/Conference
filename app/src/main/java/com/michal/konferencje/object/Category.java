package com.michal.konferencje.object;

import com.google.firebase.storage.StorageReference;

import java.util.List;

/**
 * Created by michal on 16.08.17.
 */

public class Category {
    String name;
    private StorageReference photoConference;
    List<Conference> conferenceList;

    public Category(String name, List<Conference> conferenceList) {
        this.name = name;
        this.conferenceList = conferenceList;
    }

    public Category(){

    }

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Conference> getConferenceList() {
        return conferenceList;
    }

    public void setConferenceList(List<Conference> conferenceList) {
        this.conferenceList = conferenceList;
    }
}
