package com.example.springlab2.Files;
import java.awt.*;
import java.util.concurrent.TimeUnit;


import lombok.Data;

public class Image implements Element,Picture {
    public String ImageName;
    public Image(String name) {
        ImageName = name;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void print() {
        System.out.println("Image with name : " +this.ImageName);
    }

    @Override
    public void add(Element a) {

    }

    @Override
    public Element get(int nr) {
        return null;
    }

    @Override
    public void remove(Element a) {

    }

    @Override
    public String url() {
        return null;
    }

    @Override
    public Dimension dim() {
        return null;
    }

//    @Override
//    public Dimension dim() {
//        return null;
//    }
}