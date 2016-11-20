package org.kamilkurek.onlinepass.mvc.controllers;

import de.slackspace.openkeepass.domain.Entry;
import org.kamilkurek.onlinepass.keepass.KeepassReader;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by kamkurek on 16.11.2016.
 */

@Controller
@RequestMapping("/entries")
public class EntryController {

    private KeepassReader keepassReader;

    @ResponseBody
    @GetMapping
    public List<Entry> allEntries(@RequestParam(required = false) Map<String,String> params) {
        String groupUuid = params.get("group");
        if(groupUuid != null) {
            return keepassReader.getEntriesForGroup(groupUuid);
        }
        return keepassReader.getAllEntries();
    }

    @ResponseBody
    @GetMapping(path = "/{uuid}")
    public Entry entry(@PathVariable String uuid) {
        return keepassReader.getEntry(uuid);
    }

    @Required
    public void setKeepassReader(KeepassReader keepassReader) {
        this.keepassReader = keepassReader;
    }

}
