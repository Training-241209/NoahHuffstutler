package com.impurse;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.reimbursement.models") // Scanning of entities in this package
@ComponentScan("com.reimbursement") // Scanning of all components in com.reimbursement
@EnableJpaRepositories("com.reimbursement.DAOs") // Enablement of JPA DAOs in this package
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
