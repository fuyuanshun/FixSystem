package com.fys.fixsystem.pojo;

/**
 * 用户反馈信息的JavaBean
 */
public class UInfo {
    private Integer id;
    private String name;
    private String floor;
    private String room;
    private String phone;
    private String info;
    private String createDate;


    public UInfo(Integer id, String name, String floor, String room, String phone, String info, String createDate) {
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.room = room;
        this.phone = phone;
        this.info = info;
        this.createDate = createDate;
    }

    public UInfo(String name, String floor, String room, String phone, String info, String createDate) {
        this.name = name;
        this.floor = floor;
        this.room = room;
        this.phone = phone;
        this.info = info;
        this.createDate = createDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}