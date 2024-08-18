package com.github.jcactusdev.example_crud_client.services;

import java.util.List;

import com.github.jcactusdev.example_crud_client.entity.Organization;

public interface OrganizationService {

    Organization create(Organization organization);

    List<Organization> read();

    Organization read(Long id);

    Organization updateObject(Organization organization);

    void deleteById(Long id);

}
