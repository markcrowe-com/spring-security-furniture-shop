package io.gitlab.markcrowe.furniture.shop.app.services;

import io.gitlab.markcrowe.furniture.shop.app.model.SimpleRoles;
import io.gitlab.markcrowe.furniture.shop.app.model.SimpleUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleUserService {

    static ArrayList<SimpleUser> simpleUsers = new ArrayList<>();

    private static final String DEFAULT_PASSWORD = "pass";

    static
    {
        simpleUsers.add(new SimpleUser(DEFAULT_PASSWORD, SimpleRoles.USER, "ann"));
        simpleUsers.add(new SimpleUser(DEFAULT_PASSWORD, SimpleRoles.SUPER_ADMIN, "bob"));
        simpleUsers.add(new SimpleUser(DEFAULT_PASSWORD, SimpleRoles.ADMIN, "tom"));
    }

    public List<SimpleUser> getSimpleUsers() {
        return simpleUsers;
    }
}
