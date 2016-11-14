package org.kamilkurek.onlinepass.keepass;

import de.slackspace.openkeepass.KeePassDatabase;
import de.slackspace.openkeepass.domain.*;
import org.kamilkurek.onlinepass.config.ConfigReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * Created by kamil on 2016-04-08.
 */
public class KeepassReaderImpl implements KeepassReader {

    private final KeePassFile database;
    private final ConfigReader configReader;

    public KeepassReaderImpl(ConfigReader configReader) throws IOException {
        this.configReader = configReader;
        try (InputStream resource = new FileInputStream(configReader.getKeepassFileLocation())) {
            KeePassDatabase keePassDatabase = KeePassDatabase.getInstance(resource);
            database = keePassDatabase.openDatabase(configReader.getKeepassPassword());
        }
    }

    @Override
    public List<Entry> getAllEntries() {
        return database.getEntries();
    }

    @Override
    public Entry getEntry(String uuid) {
        return database.getEntryByUUID(UUID.fromString(uuid));
    }

    @Override
    public void updateEntry(Entry entry, String title, String url, String login, String password) {
        update("Title", entry, title);
        update("URL", entry, url);
        update("UserName", entry, login);
        update("Password", entry, password);

        KeePassDatabase.write(database, configReader.getKeepassPassword(), configReader.getKeepassFileLocation());
    }

    private void update(String property, Entry entry, String value) {
        List<Property> properties = entry.getProperties();
        Property oldProperty = entry.getPropertyByName(property);
        properties.remove(oldProperty);
        properties.add(new Property(oldProperty.getKey(), value, oldProperty.isProtected()));
    }

    private Group getGroupForEntry(Group group, Entry entry) {
        if(group.getEntries().contains(entry)) {
            return group;
        }
        for(Group innerGroup : group.getGroups()) {
            Group groupForEntry = getGroupForEntry(innerGroup, entry);
            if(groupForEntry != null) {
                return groupForEntry;
            }
        }
        throw new IllegalStateException("Can't find a group for the given entry");
    }


}
