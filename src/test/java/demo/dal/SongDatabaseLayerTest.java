package demo.dal;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SongDatabaseLayerTest {

    @org.junit.jupiter.api.Test
    void getSongs() throws SQLException {
        SongDatabaseLayer songDatabaseLayer = new SongDatabaseLayer();
        List<String[]> songs = songDatabaseLayer.getSongs();
        assertTrue(songs.size()==110);
    }
}