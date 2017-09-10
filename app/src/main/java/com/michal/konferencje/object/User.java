package com.michal.konferencje.object;

import java.util.Date;
import java.util.List;

/**
 * Created by michal on 23.04.17.
 */

public class User {
    private String idUser;
    private String email;
    private String firstNameUser;
    private String surnameUser;
    private Date dateOfBirthUser;
    private List<String> conferenceIdList;
    private List<String> abstractIdList;

    public User() {

    }

    public User(String idUser,String email, String firstNameUser, String surnameUser,
                Date dateOfBirthUser, List<String> conferenceIdList, List<String> abstractIdList) {
        this.idUser = idUser;
        this.email = email;
        this.firstNameUser = firstNameUser;
        this.surnameUser = surnameUser;
        this.dateOfBirthUser = dateOfBirthUser;
        this.conferenceIdList = conferenceIdList;
        this.abstractIdList = abstractIdList;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstNameUser() {
        return firstNameUser;
    }

    public void setFirstNameUser(String firstNameUser) {
        this.firstNameUser = firstNameUser;
    }

    public String getSurnameUser() {
        return surnameUser;
    }

    public void setSurnameUser(String surnameUser) {
        this.surnameUser = surnameUser;
    }

    public Date getDateOfBirthUser() {
        return dateOfBirthUser;
    }

    public void setDateOfBirthUser(Date dateOfBirthUser) {
        this.dateOfBirthUser = dateOfBirthUser;
    }

    public List<String> getConferenceIdList() {
        return conferenceIdList;
    }

    public void setConferenceIdList(List<String> conferenceIdList) {
        this.conferenceIdList = conferenceIdList;
    }

    public List<String> getAbstractIdList() {
        return abstractIdList;
    }

    public void setAbstractIdList(List<String> abstractIdList) {
        this.abstractIdList = abstractIdList;
    }
}
