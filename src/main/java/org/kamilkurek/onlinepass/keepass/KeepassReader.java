package org.kamilkurek.onlinepass.keepass;

import de.slackspace.openkeepass.domain.Entry;

import java.util.List;

/**
 * Created by kamil on 2016-04-14.
 */
public interface KeepassReader {

    List<Entry> getAllEntries();
    Entry getEntry(String uuid);
    void updateEntry(Entry entry, String title, String url, String login, String password);

}
