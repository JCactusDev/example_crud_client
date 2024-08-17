package com.github.jcactusdev.example_crud_client.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.github.jcactusdev.example_crud_client.entity.Organization;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Organization create(Organization organization) {
        try {
            return restTemplate.postForObject("http://localhost:8080/api/organization", organization, Organization.class);
        } catch (RestClientException e) {
            return null;
        }
    }

    @Override
    public List<Organization> read() {
        Organization[] result = restTemplate.getForObject("http://localhost:8080/api/organization", Organization[].class);
        if (result == null) {
            return new ArrayList<>();
        }
        return Arrays.asList(result);
    }

    @Override
    public Organization read(Long id) {
        try {
            return restTemplate.getForObject("http://localhost:8080/api/organization/" + id, Organization.class);
        } catch (RestClientException e) {
            return null;
        }
    }

    @Override
    public Organization updateObject(Organization organization) {
        try {
            return restTemplate.patchForObject("http://localhost:8080/api/organization", organization, Organization.class);
        } catch (RestClientException e) {
            return null;
        }
    }

}
