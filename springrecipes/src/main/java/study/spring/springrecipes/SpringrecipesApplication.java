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
import study.spring.springrecipes.shop.Product;
import study.spring.springrecipes.shop.config.ShopConfiguration;

//@SpringBootApplication
@ComponentScan(
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern = {"study.spring.springrecipes.sequence.*Dao",
                                   "study.spring.springrecipes.sequence.*Service"})
        },
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = {org.springframework.stereotype.Controller.class}
                )
        }
)
public class SpringrecipesApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringrecipesApplication.class, args);

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ShopConfiguration.class);

        Product aaa = applicationContext.getBean("aaa", Product.class);
        Product cdrw = applicationContext.getBean("cdrw", Product.class);

        System.out.println(aaa);
        System.out.println(cdrw);
    }
}
