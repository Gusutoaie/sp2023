package com.example.springlab2.Files;
import java.awt.*;
import java.util.concurrent.TimeUnit;


import com.example.springlab2.service.Visitor;
import jakarta.persistence.Entity;


public class Image implements Element,Picture,Visitee {
    public String ImageName;
    public Image(String name) {
        ImageName = name;
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Image() {

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

    @Override
    public void accept(Visitor v) {
        v.visitImage(this);
    }

}