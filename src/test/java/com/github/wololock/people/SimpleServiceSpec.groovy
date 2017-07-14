package com.github.wololock.people

import com.github.wololock.RestDemoApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

    @ActiveProfiles("test")
    @SpringBootTest(classes = RestDemoApplication)
    @ContextConfiguration
    class SimpleServiceSpec extends Specification {

        @Autowired
        private SimpleService simpleService

        def "test property injection"() {
            when:
            String version = simpleService.getVersion()

            then:
            version == '1.0.0-test'
        }
    }
