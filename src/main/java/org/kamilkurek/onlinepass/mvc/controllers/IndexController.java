package org.kamilkurek.onlinepass.mvc.controllers;

import org.kamilkurek.onlinepass.keepass.KeepassReaderImpl;
import de.slackspace.openkeepass.domain.Entry;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by kamil on 2016-04-08.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    private KeepassReaderImpl keepassReaderImpl;

    @RequestMapping(method = RequestMethod.GET) public String get(Model model) {
        List<Entry> entries = keepassReaderImpl.getAllEntries();
        model.addAttribute("entries",entries);
        return "index";
    }

    @Required
    public void setKeepassReaderImpl(KeepassReaderImpl keepassReaderImpl) {
        this.keepassReaderImpl = keepassReaderImpl;
    }

}
