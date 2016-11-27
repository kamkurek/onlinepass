package org.kamilkurek.onlinepass.keepass;

import de.slackspace.openkeepass.KeePassDatabase;
import de.slackspace.openkeepass.domain.*;
import org.kamilkurek.onlinepass.config.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by kamkurek on 16.11.2016.
 */
public class KeepassReaderImplTest {

    private KeepassReaderImpl keepassReader;

    @BeforeMethod
    private void setUp() throws IOException {
        Path path = Files.createTempFile("keepass", ".tmp");
        KeePassFile keePassFile = new KeePassFileBuilder("database")
                                .build();
        KeePassDatabase.write(keePassFile, "password", path.toString());

        ConfigReader configReader = mock(ConfigReader.class);
        when(configReader.getKeepassFileLocation()).thenReturn(path.toString());
        when(configReader.getKeepassPassword()).thenReturn("password");
        keepassReader = new KeepassReaderImpl(configReader);
    }

    @Test
    public void testAddEntry() {
        Group rootGroup = keepassReader.getRootGroup();
        Entry entry = new EntryBuilder()
                .title("title")
                .build();

        keepassReader.addEntry(rootGroup, entry);

        Assert.assertNotNull(keepassReader.getRootGroup().getEntryByTitle("title"));
    }

    @Test
    public void testEditEntry() {
        Group rootGroup = keepassReader.getRootGroup();
        Entry entry = new EntryBuilder()
                .title("title")
                .build();

        keepassReader.addEntry(rootGroup, entry);
        keepassReader.updateEntry(entry, "title2", null, null, null);

        Assert.assertNull(keepassReader.getRootGroup().getEntryByTitle("title"));
        Assert.assertNotNull(keepassReader.getRootGroup().getEntryByTitle("title2"));
    }

}