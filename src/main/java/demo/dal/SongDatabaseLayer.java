package demo.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDatabaseLayer {

    public List<String[]> getSongs() throws SQLException {
        List<String[]> songs = new ArrayList<>();
        // Step -1 : Load the Driver class (Optional in today's age - But still good to know)

        //Step-2:
        Connection con = DriverManager.getConnection("jdbc:postgresql://192.168.137.84:5432/ragdb", "soham", "admin");

        // Step-4:
        PreparedStatement ps = con.prepareStatement("select * from tbl_song ");


        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String[] rowData = new String[]{rs.getString("singer"),
                    rs.getString("lyricist"),
                    rs.getString("composer")
            };
            songs.add(rowData);
        }
        con.close();
        return songs;
    }



}
