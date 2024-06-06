package dev.rost.aspectmockbean.aop;

import dev.rost.aspectmockbean.service.EzService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@SpringBootTest(properties = "spring.main.allow-bean-definition-overriding=true")
class EzServiceAspectConfigMockBeanTest {

    @Autowired
    EzService ezService;

    @SpyBean
    EzServiceAspect aspect;


    @Test
    void test() {
        ezService.ezMove();

        then(aspect).should().ezMove(any());
    }



    @TestConfiguration
    static class Config {

        @Bean
        EzService ezService() {
            return Mockito.mock(EzService.class);
        }
    }
}