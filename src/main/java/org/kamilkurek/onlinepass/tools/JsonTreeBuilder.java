package org.kamilkurek.onlinepass.tools;

import com.google.gson.*;
import de.slackspace.openkeepass.domain.Group;

import java.util.List;

/**
 * Created by kamkurek on 14.11.2016.
 */
public class JsonTreeBuilder {

    public String convert(Group group) {
        JsonObject jsonObject = createJsonObjectFromGroup(group);
        return jsonObject.toString();
    }

    private JsonObject createJsonObjectFromGroup(Group group) {
        JsonObject jsonObject = new JsonObject();
        String name = group.getName();
        if(name == null) {
            name = "";
        }
        jsonObject.add("text", new JsonPrimitive(name));
        jsonObject.add("uuid", new JsonPrimitive(group.getUuid().toString()));
        List<Group> groups = group.getGroups();
        if(!groups.isEmpty()) {
            JsonArray jsonArray = new JsonArray();
            groups.forEach(g -> jsonArray.add(createJsonObjectFromGroup(g)));
            jsonObject.add("nodes", jsonArray);
        }
        return jsonObject;
    }

}
