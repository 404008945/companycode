package com.mq.study.mqpro.test;

import java.io.Serializable;

public class MqData implements Serializable {
    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
