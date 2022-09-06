package com.ziraat.personal.model;



import lombok.*;

import javax.persistence.*;
import java.util.Arrays;

@Entity
@Table(name="Users")
//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@SecondaryTable(name = "job_expiriance",pkJoinColumns = @PrimaryKeyJoinColumn(name = "user_id"))

public class User {
    @Id

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "dep_exp", table = "job_expiriance")
    private String dep_exp;

    @Column(name = "spec_exp", table = "job_expiriance")
    private String spec_exp;

    @Column(name = "position_exp", table = "job_expiriance")
    private String position_exp;

    @Column(name = "place_exp", table = "job_expiriance")
    private  String place_exp;

    @Column(name = "start_date_exp", table = "job_expiriance")
    private  String start_date_exp;

    @Column(name = "end_date_exp", table = "job_expiriance")
    private  String end_date_exp;



    @Lob
    @Column(name = "content", length = Integer.MAX_VALUE, nullable = true)
    private byte[] content;

    private String full_name;
    private String date_birth;
    private String country;
    private String city;
    private String region;
    private String address;
    private String phone_main;
    private String phone_home;
    private String phone_ext;
    private String dep_cur;
    private String spec_cur;
    private String position_cur;
    private String photos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDep_exp() {
        return dep_exp;
    }

    public void setDep_exp(String dep_exp) {
        this.dep_exp = dep_exp;
    }

    public String getSpec_exp() {
        return spec_exp;
    }

    public void setSpec_exp(String spec_exp) {
        this.spec_exp = spec_exp;
    }

    public String getPosition_exp() {
        return position_exp;
    }

    public void setPosition_exp(String position_exp) {
        this.position_exp = position_exp;
    }

    public String getPlace_exp() {
        return place_exp;
    }

    public void setPlace_exp(String place_exp) {
        this.place_exp = place_exp;
    }

    public String getStart_date_exp() {
        return start_date_exp;
    }

    public void setStart_date_exp(String start_date_exp) {
        this.start_date_exp = start_date_exp;
    }

    public String getEnd_date_exp() {
        return end_date_exp;
    }

    public void setEnd_date_exp(String end_date_exp) {
        this.end_date_exp = end_date_exp;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public void setDate_birth(String date_birth) {
        this.date_birth = date_birth;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_main() {
        return phone_main;
    }

    public void setPhone_main(String phone_main) {
        this.phone_main = phone_main;
    }

    public String getPhone_home() {
        return phone_home;
    }

    public void setPhone_home(String phone_home) {
        this.phone_home = phone_home;
    }

    public String getPhone_ext() {
        return phone_ext;
    }

    public void setPhone_ext(String phone_ext) {
        this.phone_ext = phone_ext;
    }

    public String getDep_cur() {
        return dep_cur;
    }

    public void setDep_cur(String dep_cur) {
        this.dep_cur = dep_cur;
    }

    public String getSpec_cur() {
        return spec_cur;
    }

    public void setSpec_cur(String spec_cur) {
        this.spec_cur = spec_cur;
    }

    public String getPosition_cur() {
        return position_cur;
    }

    public void setPosition_cur(String position_cur) {
        this.position_cur = position_cur;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }
    public User() {
    }
    public User(String full_name, String date_birth, String country,String city, String region,String address, String phone_main , String phone_home, String phone_ext, String dep_cur, String spec_cur, String position_cur,
                String photos, byte [] content, String dep_exp , String spec_exp ,String position_exp ,String place_exp) {
        this.full_name = full_name;
        this.date_birth = date_birth;
        this.country = country;
        this.city = city;
        this.region = region;
        this.address = address;
        this.phone_main = phone_main;
        this.phone_home = phone_home;
        this.phone_ext = phone_ext;
        this.dep_cur =dep_cur;
        this.spec_cur = spec_cur;
        this.position_cur = position_cur;
        this.photos = photos;
        this.content = content;
        this.dep_exp = dep_exp;
        this.spec_exp = spec_exp;
        this.position_cur = position_exp;
        this.place_exp = place_exp;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", dep_exp='" + dep_exp + '\'' +
                ", spec_exp='" + spec_exp + '\'' +
                ", position_exp='" + position_exp + '\'' +
                ", place_exp='" + place_exp + '\'' +
                ", start_date_exp='" + start_date_exp + '\'' +
                ", end_date_exp='" + end_date_exp + '\'' +
                ", content=" + Arrays.toString(content) +
                ", full_name='" + full_name + '\'' +
                ", date_birth='" + date_birth + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", address='" + address + '\'' +
                ", phone_main='" + phone_main + '\'' +
                ", phone_home='" + phone_home + '\'' +
                ", phone_ext='" + phone_ext + '\'' +
                ", dep_cur='" + dep_cur + '\'' +
                ", spec_cur='" + spec_cur + '\'' +
                ", position_cur='" + position_cur + '\'' +
                ", photos='" + photos + '\'' +
                '}';
    }
}
