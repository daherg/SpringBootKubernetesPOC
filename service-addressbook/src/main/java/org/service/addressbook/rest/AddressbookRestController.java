package org.service.addressbook.rest;

import org.service.addressbook.model.ModelPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class AddressbookRestController {

    private String peopleHost = "http://service-people-service:8082";

    @Autowired
    private RestTemplate restTemplate;
    private final Logger LOG = Logger.getLogger(AddressbookRestController.class.getName());

    public AddressbookRestController(RestTemplate rest) {
        this.restTemplate = rest;
    }

    public List<ModelPerson> getAddressBookMultiple(int peopleCount) {
        // Get the people service
        String peopleURL = peopleHost + "/getPeopleMultiple/" + peopleCount;
        LOG.log(Level.INFO, "### Service AddressBookMultiple Request: " + peopleURL);

        // Get info from other service
        ModelPerson[] listResult = restTemplate.getForObject(peopleURL, ModelPerson[].class);
        LOG.log(Level.INFO, "### Service AddressBookMultiple Response: " + listResult.length);
        return Arrays.asList(listResult);
    }

    public List<ModelPerson> getAddressBookSingle(int peopleCount) {
        // Get the people service
        String peopleURL = peopleHost + "/getPeopleSingle/";
        LOG.log(Level.INFO, "### Service getAddressBookSingle Request: " + peopleURL + ". peopleCount = " + peopleCount);

        // Generate a list of persons
        List<ModelPerson> listResult = new ArrayList<>();

        // Get info from other service
        for (int i = 0; i < peopleCount; i++) {
            listResult.add(restTemplate.getForObject(peopleURL, ModelPerson.class));
        }
        // Get info from other service
        LOG.log(Level.INFO, "### Service getAddressBookSingle Response: " + listResult.size());

        return listResult;
    }
}