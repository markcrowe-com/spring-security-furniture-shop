package io.gitlab.markcrowe.furniture.shop.app.services;

import io.gitlab.markcrowe.furniture.shop.app.model.SimpleRoles;
import io.gitlab.markcrowe.furniture.shop.app.model.SimpleUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class SimpleUserService {

    static List<SimpleUser> simpleUserList = new ArrayList<>();

    private static final String DEFAULT_PASSWORD = "pass";

    static
    {
        simpleUserList.add(new SimpleUser(DEFAULT_PASSWORD,  SimpleRoles.SUPER_ADMIN, "bob"));
        simpleUserList.add(new SimpleUser(DEFAULT_PASSWORD, SimpleRoles.ADMIN, "tom"));
        simpleUserList.add(new SimpleUser(DEFAULT_PASSWORD, SimpleRoles.USER, "mary"));
    }

    public List<SimpleUser> getAllSimpleUsers() {
        return simpleUserList;
    }


    public boolean addASimpleUser(SimpleUser p) {
        return simpleUserList.add(p);
    }

    public void deleteSimpleUserByUsername(String username) {
        Iterator<SimpleUser> iterator = simpleUserList.iterator();
        while (iterator.hasNext()) {
            SimpleUser simpleUser = iterator.next();
            if (simpleUser.getUsername().equalsIgnoreCase(username)) {
                iterator.remove();
            }
        }
    }
}
