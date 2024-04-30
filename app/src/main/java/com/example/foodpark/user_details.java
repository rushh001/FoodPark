package com.example.foodpark;

public class user_details {
    String userId;
    String userName;
    String userProfile;
    String userEmail;
    String userMess;
    String userMessType;
    String userAge;
    String  userHostel;
    String userYear;
    String userState;


    public user_details() {
    }

    public user_details(String userId, String userName, String userProfile, String userEmail,
                        String userMess, String userMessType, String userAge, String userHostel,
                        String userYear, String userState) {
        this.userId = userId;
        this.userName = userName;
        this.userProfile = userProfile;
        this.userEmail = userEmail;
        this.userMess = userMess;
        this.userMessType = userMessType;
        this.userAge = userAge;
        this.userHostel = userHostel;
        this.userYear = userYear;
        this.userState= userState;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMess() {
        return userMess;
    }

    public void setUserMess(String userMess) {
        this.userMess = userMess;
    }

    public String getUserMessType() {
        return userMessType;
    }

    public void setUserMessType(String userMessType) {
        this.userMessType = userMessType;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserHostel() {
        return userHostel;
    }

    public void setUserHostel(String userHostel) {
        this.userHostel = userHostel;
    }

    public String getUserYear() {
        return userYear;
    }

    public void setUserYear(String userYear) {
        this.userYear = userYear;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }
}
