package com.roerdev.arqhexagonalmodular;

import com.roerdev.arqhexagonalmodular.product.port.output.dao.ProductDao;
import com.roerdev.arqhexagonalmodular.product.services.ProductGetAllOrderedService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.roerdev.arqhexagonalmodular"})
@EnableJpaRepositories(basePackages={"com.roerdev.arqhexagonalmodular.product.adapter.jpa"})
@EntityScan(basePackages={"com.roerdev.arqhexagonalmodular.product.adapter.entity",
                            "com.roerdev.arqhexagonalmodular.stock.adapter.entity"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
