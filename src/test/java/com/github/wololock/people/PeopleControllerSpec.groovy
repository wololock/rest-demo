package com.github.wololock.people

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.Matchers.hasSize
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ContextConfiguration
@WebMvcTest(PeopleController)
class PeopleControllerSpec extends Specification {

    @Autowired
    private MockMvc request

    def "should return 3 people"() {
        when:
        def response = request.perform(get("/people"))

        then:
        response.andExpect(status().isOk())
                .andExpect(jsonPath('$', hasSize(3)))
    }

    def "should return Joe Doe as the 1st element of the list"() {
        when:
        def response = request.perform(get("/people"))

        then:
        response.andExpect(status().isOk())
                .andExpect(jsonPath('$.[0].id', is("100001")))
                .andExpect(jsonPath('$.[0].firstName', is("Joe")))
                .andExpect(jsonPath('$.[0].lastName', is("Doe")))
                .andExpect(jsonPath('$.[0].birthDate', is("1965-01-01")))
    }

    def "should return Mark Smith as the 2nd element of the list"() {
        when:
        def response = request.perform(get("/people"))

        then:
        response.andExpect(status().isOk())
                .andExpect(jsonPath('$.[1].id', is("100003")))
                .andExpect(jsonPath('$.[1].firstName', is("Mark")))
                .andExpect(jsonPath('$.[1].lastName', is("Smith")))
                .andExpect(jsonPath('$.[1].birthDate', is("1971-04-12")))
    }

    def "should return Adam J. Adams as the 3rd element of the list"() {
        when:
        def response = request.perform(get("/people"))

        then:
        response.andExpect(status().isOk())
                .andExpect(jsonPath('$.[2].id', is("100021")))
                .andExpect(jsonPath('$.[2].firstName', is("Adam")))
                .andExpect(jsonPath('$.[2].lastName', is("J. Adams")))
                .andExpect(jsonPath('$.[2].birthDate', is("1988-07-25")))
    }
}
