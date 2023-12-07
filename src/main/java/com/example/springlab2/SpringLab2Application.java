package com.example.springlab2;

import com.example.springlab2.Files.*;
import com.example.springlab2.difexample.ClientComponent;
import com.example.springlab2.difexample.SingletonComponent;
import com.example.springlab2.difexample.TransientComponent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringLab2Application {
    public static void main(String[] args) {
        Cly cly;

        ApplicationContext context = SpringApplication.run(SpringLab2Application.class, args);
        TransientComponent transientBean =
                context.getBean(TransientComponent.class);
        transientBean.operation();
// Note that every time an instance is required,
// the DI context creates a new one
        transientBean = context.getBean(TransientComponent.class);
        transientBean.operation();
// Gets an instance of SingletonComponent from the DI context
// Note that the unique instance was created while
// application was loaded, before creating
// the transient instances
        SingletonComponent singletonBean =
                context.getBean(SingletonComponent.class);
        singletonBean.operation();
// Note that every time an instance is required,
// the DI returns the same unique one
        singletonBean = context.getBean(SingletonComponent.class);
        singletonBean.operation();
// Gets an instance of another class that
// requires singleton/transient components
// Note where this instance was created and what beans
// were used to initialize it
        ClientComponent c = context.getBean(ClientComponent.class);
        c.operation();
// One can also request an instance from DI context by name
        c = (ClientComponent)context.getBean("clientComponent");
        c.operation();
        new RenderContentVisitor().visitBook(c);



        //        Section cap1 = new Section("Capitolul 1");
//        Pharagraph p1 = new Pharagraph("Paragraph 1");
//        cap1.add(p1);
//        Pharagraph p2 = new Pharagraph("Paragraph 2");
//        cap1.add(p2);
//        Pharagraph p3 = new Pharagraph("Paragraph 3");
//        cap1.add(p3);
//        Pharagraph p4 = new Pharagraph("Paragraph 4");
//        cap1.add(p4);
//        System.out.println("Printing without Alignment");
//        System.out.println();
//        cap1.print();
//        p1.setAlignStrategy(new AlignCenter());
//        p2.setAlignStrategy(new AlignRight());
//        p3.setAlignStrategy(new AlignLeft());
//
//
//        System.out.println();
//        System.out.println();
//        System.out.println("Printing with Alignment");
//        System.out.println();
//        cap1.print();
    }

}
