package com.github.wololock.people

import com.github.tomakehurst.wiremock.junit.WireMockRule
import com.github.tomjankes.wiremock.WireMockGroovy
import org.junit.Rule
import spock.lang.Specification
import spock.lang.Subject

class WireMockExampleSpec extends Specification {

    @Rule
    WireMockRule wireMockRule = new WireMockRule(8080)

    @Subject
    WireMockGroovy wireMockStub = new WireMockGroovy(8080)

    def "some integration test that tests feature using external REST resource" () {
        given:
        wireMockStub.stub {
            request {
                method "GET"
                url "/index"
            }
            response {
                status 200
                body getClass().getClassLoader().getResourceAsStream('html/index.html').text
                headers {
                    "Content-Type" "text/plain"
                }
            }
        }

        when:
        def response = "http://localhost:8080/index".toURL().text
        
        then:
        response.contains('Hello world!')
    }
}

