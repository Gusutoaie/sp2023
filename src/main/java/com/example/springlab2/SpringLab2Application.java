package com.example.springlab2;

import com.example.springlab2.Files.*;
import com.example.springlab2.difexample.ClientComponent;
import com.example.springlab2.difexample.SingletonComponent;
import com.example.springlab2.difexample.TransientComponent;
import com.example.springlab2.service.Implementation.BookSaveJson;
import com.example.springlab2.service.Implementation.VisitorImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringLab2Application {

    public static void createTableOfContent() {
        Book b = new Book("The book");
        Section cap1 = new Section("Chapter 1");
        Section cap11 = new Section("Subchapter 1.1");
        Section cap2 = new Section("Chapter 2");
        cap1.add(new Pharagraph("Paragraph 1"));
        cap1.add(new Pharagraph("Paragraph 2"));
        cap1.add(new Pharagraph("Paragraph 3"));

        cap11.add(new ImageProxy("ImageOne"));
        cap11.add(new Image("ImageTwo"));

        cap2.add(new Pharagraph("Paragraph 4"));

        cap1.add(cap11);
        cap1.add(new Pharagraph("Some text"));
        cap1.add(new Table("Table 1"));
        b.addContent(cap1);
        b.addContent(cap2);
        TableOfContentUpdate tocUpdate = new TableOfContentUpdate();
        b.accept(tocUpdate);
        tocUpdate.getToC().accept(new VisitorImpl());
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringLab2Application.class, args);

        createTableOfContent();
        Book b = new Book("The book");
        Section cap1 = new Section("Chapter 1");
        Section cap11 = new Section("Subchapter 1.1");
        Section cap2 = new Section("Chapter 2");
        cap1.add(new Pharagraph("Paragraph 1"));
        cap1.add(new Pharagraph("Paragraph 2"));
        cap1.add(new Pharagraph("Paragraph 3"));

        cap11.add(new ImageProxy("ImageOne"));
        cap11.add(new Image("ImageTwo"));

        cap2.add(new Pharagraph("Paragraph 4"));
        cap1.add(cap11);
        cap1.add(new Pharagraph("Some text"));
        cap1.add(new Table("Table 1"));
        b.addAuthor(new Author("Giugiuc"));
        b.addContent(new Pharagraph("testt"));
        b.accept(new VisitorImpl());
        b.addContent(cap1);
        b.addContent(cap2);

        BookSaveJson bookSaveVisitor = new BookSaveJson();
        b.accept(bookSaveVisitor);
        //bookSaveVisitor.exportJSON();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

}
