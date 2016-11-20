package org.kamilkurek.onlinepass.mvc.controllers;

import de.slackspace.openkeepass.domain.Group;
import de.slackspace.openkeepass.domain.GroupBuilder;
import org.kamilkurek.onlinepass.model.GroupFacade;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.testng.Assert.*;

/**
 * Created by kamkurek on 20.11.2016.
 */
public class GroupFacadeTest {

    @Test
    public void testConvertGroupToJsonForSingleGroup() {
        Group group = new GroupBuilder("Group1").build();

        GroupFacade groupFacade = new GroupFacade(group);

        assertEquals(groupFacade.getName(), "Group1");
    }

    @Test
    public void testConvertGroupToJsonForMultiGroup() {
        Group group = new GroupBuilder("Group1")
                .addGroup(new GroupBuilder("Group1-1")
                        .addGroup(new GroupBuilder("Group1-1-1").build())
                        .build())
                .addGroup(new GroupBuilder("Group1-2").build())
                .build();

        GroupFacade groupFacade = new GroupFacade(group);

        assertEquals(groupFacade.getName(), "Group1");
        assertNotNull(groupFacade.getGroups());
        assertEquals(groupFacade.getGroups().size(), 2);
        assertEquals(groupFacade.getGroups().get(0).getName(), "Group1-1");
        assertEquals(groupFacade.getGroups().get(1).getName(), "Group1-2");
        assertEquals(groupFacade.getGroups().get(0).getGroups().size(), 1);
        assertEquals(groupFacade.getGroups().get(0).getGroups().get(0).getName(), "Group1-1-1");
    }

    @Test
    public void testConvertGroupToJsonUuidWritten() {
        UUID uuid = UUID.randomUUID();
        Group group = new GroupBuilder(uuid).build();

        GroupFacade groupFacade = new GroupFacade(group);

        assertEquals(groupFacade.getUuid(), uuid.toString());
    }

}