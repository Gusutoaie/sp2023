package com.example.springlab2.Files;

import lombok.Data;

@Data
public class Image {
    String ImageName;

    @Override
    public String toString() {
        return "Image{" +
                "ImageName='" + ImageName + '\'' +
                '}';
    }

    public Image(String imageName) {
        ImageName = imageName;
    }
}