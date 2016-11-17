package org.kamilkurek.onlinepass.keepass;

import de.slackspace.openkeepass.KeePassDatabase;
import de.slackspace.openkeepass.domain.*;
import de.slackspace.openkeepass.domain.zipper.GroupZipper;
import org.kamilkurek.onlinepass.config.ConfigReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

/**
 * Created by kamil on 2016-04-08.
 */
public class KeepassReaderImpl implements KeepassReader {

    private KeePassFile keePassFile;
    private final ConfigReader configReader;

    public KeepassReaderImpl(ConfigReader configReader) {
        this.configReader = configReader;
        keePassFile = openDatabase();
    }

    private KeePassFile openDatabase() {
        KeePassDatabase keePassDatabase = KeePassDatabase.getInstance(configReader.getKeepassFileLocation());
        return keePassDatabase.openDatabase(configReader.getKeepassPassword());
    }

    @Override
    public List<Entry> getAllEntries() {
        return keePassFile.getEntries();
    }

    @Override
    public Entry getEntry(String uuid) {
        return keePassFile.getEntryByUUID(UUID.fromString(uuid));
    }

    @Override
    public void updateEntry(Entry entry, String title, String url, String login, String password) {
        Entry newEntry = new EntryBuilder(entry)
                .title(title)
                .url(url)
                .username(login)
                .password(password)
                .build();

        Group group = getGroupForEntry(getRootGroup(), entry);
        GroupZipper groupZipper = new GroupZipper(keePassFile);
        navigateToGroup(groupZipper, group);

        Group newGroup = new GroupBuilder(group)
                .removeEntry(entry)
                .addEntry(newEntry)
                .build();

        groupZipper.replace(newGroup);
        saveAndReload();
    }

    private void saveAndReload() {
        save();
        keePassFile = openDatabase();
    }

    private void navigateToGroup(GroupZipper groupZipper, Group group) {
        while(!group.equals(groupZipper.getNode())) {
            groupZipper = checkLevel(groupZipper, group);
            groupZipper.down();
        }
    }

    @Override
    public Group getRootGroup() {
        return new GroupZipper(keePassFile).getNode();
    }

    @Override
    public void addEntry(Group group, Entry entry) {
        GroupZipper groupZipper = new GroupZipper(keePassFile);
        navigateToGroup(groupZipper, group);
        Group newGroup = new GroupBuilder(group).addEntry(entry).build();
        groupZipper.replace(newGroup);
        keePassFile = groupZipper.close();
        saveAndReload();
    }

    @Override
    public List<Entry> getEntriesForGroup(String groupUUID) {
        Group group = keePassFile.getGroupByUUID(UUID.fromString(groupUUID));
        return group.getEntries();
    }

    private void save() {
        String keepassFileLocation = configReader.getKeepassFileLocation();
        try {
            Files.move(Paths.get(keepassFileLocation), Paths.get(keepassFileLocation+"."+System.currentTimeMillis()));
            String keepassPassword = configReader.getKeepassPassword();
            KeePassDatabase.write(keePassFile, keepassPassword, keepassFileLocation);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private GroupZipper checkLevel(GroupZipper groupZipper, Group group) {
        if(groupZipper.getNode().equals(group)) {
            return groupZipper;
        }
        if(groupZipper.canRight()) {
            checkLevel(groupZipper.right(), group);
        }
        return groupZipper;
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
