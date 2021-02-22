package study.spring.springrecipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import study.spring.springrecipes.sequence.SequenceGenerator;
import study.spring.springrecipes.sequence.config.SequenceGeneratorConfiguration;

//@SpringBootApplication
public class SpringrecipesApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringrecipesApplication.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);
        SequenceGenerator sequenceGenerator = (SequenceGenerator)context.getBean(SequenceGenerator.class);

        System.out.println(sequenceGenerator.getSequence());
        System.out.println(sequenceGenerator.getSequence());
    }
}
