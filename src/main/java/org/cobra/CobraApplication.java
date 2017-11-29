package org.cobra;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class CobraApplication extends SpringBootServletInitializer /*implements CommandLineRunner */{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }

    public static void main(String[] args) {
        configureApplication(new SpringApplicationBuilder()).run(args);
    }

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder
                .properties("spring.config.name:application"
                                                    +",application-log4j"
                                                    +",application-jdbc"
                                                    +",application-mvc"
                                                    +",application-devtools"
                                                    +",messages")
                .bannerMode(Banner.Mode.OFF)
                .sources(CobraApplication.class);
    }

}
