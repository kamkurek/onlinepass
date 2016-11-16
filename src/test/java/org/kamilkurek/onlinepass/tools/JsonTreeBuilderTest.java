package org.kamilkurek.onlinepass.tools;

import com.google.gson.Gson;
import de.slackspace.openkeepass.domain.Group;
import de.slackspace.openkeepass.domain.GroupBuilder;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

import static org.testng.Assert.*;

/**
 * Created by kamkurek on 14.11.2016.
 */
public class JsonTreeBuilderTest {

    private JsonTreeBuilder jsonTreeBuilder;

    @BeforeMethod
    public void setUp() {
        jsonTreeBuilder = new JsonTreeBuilder();
    }

    @Test
    public void testConvertGroupToJsonForSingleGroup() {
        Group group = new GroupBuilder("Group1").build();

        String json = jsonTreeBuilder.convert(group);

        Node node = new Gson().fromJson(json, Node.class);
        assertEquals(node.text, "Group1");
    }

    @Test
    public void testConvertGroupToJsonForMultiGroup() {
        Group group = new GroupBuilder("Group1")
                .addGroup(new GroupBuilder("Group1-1")
                        .addGroup(new GroupBuilder("Group1-1-1").build())
                        .build())
                .addGroup(new GroupBuilder("Group1-2").build())
                .build();

        String json = jsonTreeBuilder.convert(group);

        Node node = new Gson().fromJson(json, Node.class);
        assertEquals(node.text, "Group1");
        assertNotNull(node.nodes);
        assertEquals(node.nodes.size(), 2);
        assertEquals(node.nodes.get(0).text, "Group1-1");
        assertEquals(node.nodes.get(1).text, "Group1-2");
        assertEquals(node.nodes.get(0).nodes.size(), 1);
        assertEquals(node.nodes.get(0).nodes.get(0).text, "Group1-1-1");
    }

    @Test
    public void testConvertGroupToJsonUuidWritten() {
        UUID uuid = UUID.randomUUID();
        Group group = new GroupBuilder(uuid).build();

        String json = jsonTreeBuilder.convert(group);

        Node node = new Gson().fromJson(json, Node.class);
        assertEquals(node.uuid, uuid.toString());
    }

    private class Node {
        String text;
        String uuid;
        List<Node> nodes;
    }



}