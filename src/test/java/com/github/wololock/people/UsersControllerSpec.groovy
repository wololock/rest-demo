package com.github.wololock.people

import spock.lang.Specification

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
@WebMvcTest(UsersController)
class UsersControllerSpec extends Specification {

    @Autowired
    private MockMvc request

    def "should return 3 users"() {
        when:
        def response = request.perform(get("/users"))

        then:
        response.andExpect(status().isOk())
                .andExpect(jsonPath('$', hasSize(3)))
    }

    def "should return Joe as the 1st element of the list"() {
        when:
        def response = request.perform(get("/users"))

        then:
        response.andExpect(status().isOk())
                .andExpect(jsonPath('$.[0].id', is("100001")))
                .andExpect(jsonPath('$.[0].firstName', is("Joe")))
                .andExpect(jsonPath('$.[0].age', is(51)))
    }

    def "should return Mark as the 2nd element of the list"() {
        when:
        def response = request.perform(get("/users"))

        then:
        response.andExpect(status().isOk())
                .andExpect(jsonPath('$.[1].id', is("100003")))
                .andExpect(jsonPath('$.[1].firstName', is("Mark")))
                .andExpect(jsonPath('$.[1].age', is(45)))
    }

    def "should return Adam as the 3rd element of the list"() {
        when:
        def response = request.perform(get("/users"))

        then:
        response.andExpect(status().isOk())
                .andExpect(jsonPath('$.[2].id', is("100021")))
                .andExpect(jsonPath('$.[2].firstName', is("Adam")))
                .andExpect(jsonPath('$.[2].age', is(28)))
    }
}
