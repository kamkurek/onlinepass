package org.kamilkurek.onlinepass.mvc.controllers;

import de.slackspace.openkeepass.domain.Group;
import org.kamilkurek.onlinepass.keepass.KeepassReader;
import org.kamilkurek.onlinepass.model.GroupFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kamkurek on 16.11.2016.
 */

@Controller
@RequestMapping("/groups")
public class GroupController {

    private KeepassReader keepassReader;

    public GroupController(KeepassReader keepassReader) {
        this.keepassReader = keepassReader;
    }

    @ResponseBody
    @GetMapping
    public List<GroupFacade> groups() {
        Group rootGroup = keepassReader.getRootGroup();
        return Arrays.asList(new GroupFacade(rootGroup));
    }

}
