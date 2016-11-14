package org.kamilkurek.onlinepass.mvc.controllers;

import org.kamilkurek.onlinepass.keepass.KeepassReader;
import de.slackspace.openkeepass.domain.Entry;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by kamil on 2016-04-08.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    private KeepassReader keepassReader;

    @RequestMapping(method = RequestMethod.GET) public String get(Model model) {
        List<Entry> entries = keepassReader.getAllEntries();
        model.addAttribute("entries",entries);
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String post(
            @RequestParam String title,
            @RequestParam String url,
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String uuid) {
        Entry entry = keepassReader.getEntry(uuid);
        keepassReader.updateEntry(entry, title, url, login, password);
        return "redirect:/";
    }


    @Required
    public void setKeepassReader(KeepassReader keepassReader) {
        this.keepassReader = keepassReader;
    }

}
