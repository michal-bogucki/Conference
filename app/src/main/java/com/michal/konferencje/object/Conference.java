package com.michal.konferencje.object;

import com.google.firebase.storage.StorageReference;

import java.util.Date;
import java.util.List;

/**
 * Created by michal on 02.05.17.
 */

public class Conference {
    private String nameConference;
    private String organizerIdConference;
    private String descriptionConference;//opis
    private Date dateConference;
    private StorageReference photoConference;
    private List<String> userID;

    public StorageReference getPhotoConference() {
        return photoConference;
    }

    public void setPhotoConference(StorageReference photoConference) {
        this.photoConference = photoConference;
    }

    private List<String> abstarctID;

    public Conference(String nameConference, Date dateConference) {
        this.nameConference = nameConference;
        this.dateConference = dateConference;
    }

    public Conference() {
    }

    public Conference(String nameConference, String organizerIdConference, String descriptionConference,
                      Date dateConference, List<String> userID, List<String> abstarctID) {
        this.nameConference = nameConference;
        this.organizerIdConference = organizerIdConference;
        this.descriptionConference = descriptionConference;
        this.dateConference = dateConference;
        this.userID = userID;
        this.abstarctID = abstarctID;
    }

    public String getNameConference() {
        return nameConference;
    }

    public void setNameConference(String nameConference) {
        this.nameConference = nameConference;
    }

    public String getOrganizerIdConference() {
        return organizerIdConference;
    }

    public void setOrganizerIdConference(String organizerIdConference) {
        this.organizerIdConference = organizerIdConference;
    }

    public String getDescriptionConference() {
        return descriptionConference;
    }

    public void setDescriptionConference(String descriptionConference) {
        this.descriptionConference = descriptionConference;
    }

    public Date getDateConference() {
        return dateConference;
    }

    public void setDateConference(Date dateConference) {
        this.dateConference = dateConference;
    }

    public List<String> getUserID() {
        return userID;
    }

    public void setUserID(List<String> userID) {
        this.userID = userID;
    }

    public List<String> getAbstarctID() {
        return abstarctID;
    }

    public void setAbstarctID(List<String> abstarctID) {
        this.abstarctID = abstarctID;
    }
}
