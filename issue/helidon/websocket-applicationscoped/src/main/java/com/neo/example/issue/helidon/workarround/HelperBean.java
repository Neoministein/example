package com.neo.example.issue.helidon.workarround;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class HelperBean {

    protected Map<String, List<String>> messageMap = new HashMap<>();

    public Map<String, List<String>> getMessageMap() {
        return messageMap;
    }
}
