package com.example.springlab2.Files;

import com.example.springlab2.service.Visitor;
import jakarta.persistence.*;
import lombok.Data;

import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Section extends BaseElement implements Visitee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @Column
    public String title;
    @OneToMany(targetEntity = BaseElement.class)
    public List<Element> el = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    public Section() {

    }


    @Override
    public void add(Element a) {
        el.add(a);
    }

    @Override
    public Element get(int nr) {
        return null;
    }

    @Override
    public void print() {

    }

    @Override
    public void remove(Element a) {

    }



    @Override
    public void accept(Visitor visitor) {
        visitor.visitSection(this);
        for(Element c: el){
            c.accept(visitor);
    }
    }


}
