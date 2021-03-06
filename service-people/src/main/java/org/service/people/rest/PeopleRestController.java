package org.service.people.rest;

import org.service.people.helper.HelperRandom;
import org.service.people.model.ModelPerson;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class PeopleRestController {

    private RestTemplate restTemplate;

    private static final Logger LOG = Logger.getLogger(PeopleRestController.class.getName());

    public PeopleRestController(RestTemplate rest) {
        this.restTemplate = rest;
    }

    public List<ModelPerson> getPeopleMultiple(int peopleCount) {
        LOG.log(Level.INFO, "### Service getPeopleMultiple: " + peopleCount);
        // Generate a list of persons
        List<ModelPerson> listPerson = new ArrayList<>();

        for (int i = 0; i < peopleCount; i++) {
            LOG.log(Level.INFO, "Generate person: " + i);
            ModelPerson person = new ModelPerson();
            person.setFirstname(HelperRandom.randomAlpha(10));
            person.setLastname(HelperRandom.randomAlpha(10));
            person.setCity(HelperRandom.randomAlpha(7));
            person.setStreet(HelperRandom.randomAlpha(8));
            person.setTelephone(HelperRandom.randomNumeric(5));
            listPerson.add(person);
        }

        return listPerson;
    }

    public ModelPerson getPeopleSingle() {
        LOG.log(Level.INFO, "### Service getPeopleSingle");

        ModelPerson person = new ModelPerson();
        person.setFirstname(HelperRandom.randomAlpha(10));
        person.setLastname(HelperRandom.randomAlpha(10));
        person.setCity(HelperRandom.randomAlpha(7));
        person.setStreet(HelperRandom.randomAlpha(8));
        person.setTelephone(HelperRandom.randomNumeric(5));

        return person;
    }

    public String getException() throws Exception {
        LOG.log(Level.INFO, "### Service getException");
        throw new Exception("Exception in Service People");
    }

    public String getTestAlternative() {
        LOG.log(Level.INFO, "You called the alternative function from service: People");
        return "Alternative...";
    }
}