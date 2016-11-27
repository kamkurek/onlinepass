package org.kamilkurek.onlinepass.mvc.controllers;

import de.slackspace.openkeepass.domain.Entry;
import org.kamilkurek.onlinepass.keepass.KeepassReader;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by kamil on 2016-04-08.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    private KeepassReader keepassReader;

    @GetMapping
    public String get() {
        return "index";
    }

    @PostMapping
    public String post(
            @RequestParam String title,
            @RequestParam String url,
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String uuid) {
        Entry entry = keepassReader.getEntry(uuid);
        keepassReader.updateEntry(entry, title, url, login, password);
        keepassReader.saveAndReload();
        return "redirect:/";
    }


    @Required
    public void setKeepassReader(KeepassReader keepassReader) {
        this.keepassReader = keepassReader;
    }

}
