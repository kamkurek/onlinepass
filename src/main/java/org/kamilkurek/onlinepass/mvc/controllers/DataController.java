package org.kamilkurek.onlinepass.mvc.controllers;

import de.slackspace.openkeepass.domain.Entry;
import org.kamilkurek.onlinepass.keepass.KeepassReader;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by kamkurek on 16.11.2016.
 */

@Controller
@RequestMapping("/data")
@EnableWebMvc
public class DataController {

    private KeepassReader keepassReader;

    @RequestMapping(method = GET)
    @ResponseBody
    public List<Entry> entries() {
        return keepassReader.getAllEntries();
    }

    @RequestMapping(path = "/details", method = GET)
    @ResponseBody
    public Entry entry(@RequestParam String uuid) {
        return keepassReader.getEntry(uuid);
    }

    @Required
    public void setKeepassReader(KeepassReader keepassReader) {
        this.keepassReader = keepassReader;
    }
}
