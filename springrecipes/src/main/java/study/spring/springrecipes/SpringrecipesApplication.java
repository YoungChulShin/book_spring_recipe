package study.spring.springrecipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import study.spring.springrecipes.sequence.SequenceDao;
import study.spring.springrecipes.sequence.SequenceDaoImpl;
import study.spring.springrecipes.sequence.SequenceGenerator;
import study.spring.springrecipes.sequence.config.SequenceGeneratorConfiguration;

//@SpringBootApplication
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = {
                                "study.spring.springrecipes.sequence.*Dao",
                                "study.spring.springrecipes.sequence.*Service",
                        }
                )
        }
)
public class SpringrecipesApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringrecipesApplication.class, args);

        ApplicationContext context =
                new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);

        SequenceGenerator sequenceGenerator = (SequenceGenerator)context.getBean(SequenceGenerator.class);
        System.out.println(sequenceGenerator.getSequence());
        System.out.println(sequenceGenerator.getSequence());

        SequenceDao sequenceDao = context.getBean(SequenceDao.class);
        System.out.println(sequenceDao.getNextValue("IT"));
        System.out.println(sequenceDao.getNextValue("IT"));
    }
}
