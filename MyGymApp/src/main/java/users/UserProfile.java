package users;

import jakarta.persistence.*;
import trophies.Trophy;

@Entity
@Table(name = "userProfile")
public class UserProfile {
    @Id
    private Long id;
    private String username;
    private Integer height;
    private Integer weight;
    private Integer age;
    private String gender;
    private String location;
    private String records;
    private String trophy_name;
    private String activity_level;
    private String video;
    private String profile_picture;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }



    public String getTrophy_name() {
        return trophy_name;
    }

    public void setTrophy_name(String trophy_name) {
        this.trophy_name = trophy_name;
    }

    public String getActivity_level() {
        return activity_level;
    }

    public void setActivity_level(String activity_level) {
        this.activity_level = activity_level;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @OneToOne
    @JoinColumn(name = "user_id", unique = true)
    public User user;

    @ManyToOne
    @JoinColumn(name = "trophy_id")
    private Trophy trophy;

    public Trophy getTrophy() {
        return trophy;
    }

    public void setTrophy(Trophy trophy) {
        this.trophy = trophy;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}