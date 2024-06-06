package dev.rost.aspectmockbean.aop;

import dev.rost.aspectmockbean.service.EzService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;

@SpringBootTest
class EzServiceAspectSpyBeanTest {

    @Autowired
    EzService ezService;

    @SpyBean
    EzServiceAspect aspect;


    @Test
    void test() {
        ezService.ezMove();

        then(aspect).should().ezMove(any());
    }
}