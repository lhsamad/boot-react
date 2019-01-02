package com.alif.bootreact;

import com.alif.bootreact.domain.Car;
import com.alif.bootreact.domain.CarRepository;
import com.alif.bootreact.domain.Owner;
import com.alif.bootreact.domain.OwnerRepository;
import com.alif.bootreact.domain.User;
import com.alif.bootreact.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//https://github.com/PacktPublishing/Hands-On-Full-Stack-Development-with-Spring-Boot-2.0-and-React/tree/master/Chapter02/src/main/java/com/packt/cardatabase/domain
@SpringBootApplication
public class BootReactApplication {

    public static final Logger LOG = LoggerFactory.getLogger(BootReactApplication.class);

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private OwnerRepository ownerRepository;

    public static void main(String[] args) {
        SpringApplication.run(BootReactApplication.class, args);
        LOG.info("Hello Spring Boot");
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            userRepository.save(new User("user", "$2a$04$1.YhMIgNX/8TkCKGFUONWO1waedKhQ5KrnB30fl0Q01QKqmzLf.Zi", "USER"));
            userRepository.save(new User( "admin", "$2a$04$KNLUwOWHVQZVpXyMBNc7JOzbLiBjb9Tk9bP7KNcPI12ICuvzXQQKG", "ADMIN"));


            Owner owner1 = new Owner("John" , "Johnson");
            Owner owner2 = new Owner("Mary" , "Robinson");
            ownerRepository.save(owner1);
            ownerRepository.save(owner2);

            carRepository.save(new Car("Ford", "Mustang", "Red", "ADF-1121", 2017, 59000, owner1));
            carRepository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2014, 29000, owner2));
            carRepository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2018, 39000, owner2));

        };
    }

}

