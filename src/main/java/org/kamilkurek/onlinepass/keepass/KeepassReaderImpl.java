package org.kamilkurek.onlinepass.keepass;

import de.slackspace.openkeepass.KeePassDatabase;
import de.slackspace.openkeepass.domain.Entry;
import de.slackspace.openkeepass.domain.KeePassFile;
import org.kamilkurek.onlinepass.config.ConfigReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by kamil on 2016-04-08.
 */
public class KeepassReaderImpl implements KeepassReader {

    private KeePassFile database;

    public KeepassReaderImpl(ConfigReader configReader) throws IOException {
        try (InputStream resource = new FileInputStream(configReader.getKeepassFileLocation())) {
            KeePassDatabase keePassDatabase = KeePassDatabase.getInstance(resource);
            database = keePassDatabase.openDatabase(configReader.getKeepassPassword());
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public List<Entry> getAllEntries() {
        return database.getEntries();
    }

}
