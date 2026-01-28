package demo.controller;

import demo.dal.SongDatabaseLayer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/songs")
public class SongServlet extends HttpServlet {

    SongDatabaseLayer songDatabaseLayer=new SongDatabaseLayer();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<String[]> data=songDatabaseLayer.getSongs();
            String html="<table border='1'>";
            for(String[] row:data){
                // we concatenate BUT not recommended
                html +=  "<td>"+row[0]+"</td><td>"+row[1]+"</td><td>"+row[2]+"</td></tr>";

            }
            html+="</table>";
            resp.getWriter().println(html);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
