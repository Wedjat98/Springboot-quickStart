package com.lionlemon.springboot;

import com.lionlemon.exception.ExceptionType;
import com.lionlemon.exception.ServiceException;
import com.lionlemon.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringInitializrApplicationTests {
    @Autowired
    private Person person;
//    private Dog dog;
    @Test
    void contextLoads() throws ServiceException {
//        System.out.println(dog);

            System.out.println(person);

    }


}
