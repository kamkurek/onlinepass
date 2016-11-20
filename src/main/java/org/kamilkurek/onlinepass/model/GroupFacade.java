package org.kamilkurek.onlinepass.model;

import de.slackspace.openkeepass.domain.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamkurek on 20.11.2016.
 */
public class GroupFacade {

    private Group group;

    public GroupFacade(Group group) {
        this.group = group;
    }

    public String getUuid() {
        return String.valueOf(group.getUuid());
    }

    public String getName() {
        return group.getName();
    }

    public List<GroupFacade> getGroups() {
        List<GroupFacade> groupsFacades = new ArrayList<>();
        group.getGroups().forEach(g -> groupsFacades.add(new GroupFacade(g)));
        return groupsFacades.isEmpty()?null:groupsFacades;
    }

}
