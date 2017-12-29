package com.tutu.tallybook.web.beana;

/**
 * @author tutu
 * @time 2017/12/29
 */

public class CameraEvent {
    private String type;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public CameraEvent(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CameraEvent{" +
                "type='" + type + '\'' +
                '}';
    }
}
