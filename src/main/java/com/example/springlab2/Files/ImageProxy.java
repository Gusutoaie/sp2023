package com.example.springlab2.Files;
import com.example.springlab2.service.Visitor;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Objects;
@Entity
@NoArgsConstructor
public class ImageProxy extends BaseElement implements Visitee {


    private String imagename;

    @Transient
    private Image realImage= null;

    public ImageProxy(String imagename) {
        this.imagename = imagename;
    }

    public Image loadRealImage() {
        if (Objects.isNull(realImage)) {
            realImage = new Image(this.imagename);
            return realImage;
        }
        return realImage;
    }

    @Override
    public void print() {
        loadRealImage();
        realImage.print();
    }

    @Override
    public void remove(Element a) {

    }

    @Override
    public void add(Element e) {
        throw new UnsupportedOperationException();
    }



    @Override
    public Element get(int i) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitImageProxy(this);
    }


}

