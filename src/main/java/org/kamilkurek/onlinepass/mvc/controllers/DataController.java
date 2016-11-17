package org.kamilkurek.onlinepass.mvc.controllers;

import de.slackspace.openkeepass.domain.Entry;
import org.kamilkurek.onlinepass.keepass.KeepassReader;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 * Created by kamkurek on 16.11.2016.
 */

@Controller
@RequestMapping("/data")
public class DataController {

    private KeepassReader keepassReader;

    @ResponseBody
    @GetMapping
    public List<Entry> allEntries() {
        return keepassReader.getAllEntries();
    }

    @ResponseBody
    @GetMapping(path = "/details/{uuid}")
    public Entry entry(@PathVariable String uuid) {
        return keepassReader.getEntry(uuid);
    }

    @ResponseBody
    @GetMapping(path = "/{uuid}")
    public List<Entry> entriesForGroup(@PathVariable String uuid) {
        return keepassReader.getEntriesForGroup(uuid);
    }

    @Required
    public void setKeepassReader(KeepassReader keepassReader) {
        this.keepassReader = keepassReader;
    }

}
