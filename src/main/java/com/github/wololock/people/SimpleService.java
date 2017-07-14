package com.github.wololock.people;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
final class SimpleService {

    private final String version;

    @Autowired
    public SimpleService(@Value("${application.version}") String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }
}
