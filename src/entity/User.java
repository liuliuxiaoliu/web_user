package entity;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String userName;
    private String pwd;
    private String gender;
    private String category;
    private String interest;
    private String photo;
    private String regTime;

    public User() {
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInterest() {
        return this.interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegTime() {
        return this.regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }
}
