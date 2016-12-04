package com.study.jojonari.tobytv02;

import org.springframework.core.ParameterizedTypeReference;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class SpringTypeReference {
    public static void main(String[] args) {
        ParameterizedTypeReference<?> typeRef = new ParameterizedTypeReference<List<Map<Set<Integer>, String>>>() {};
        System.out.println(typeRef.getType());
    }






}
