package bednarhalaj.repository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

abstract class Repository {
    protected Connection con;
    protected String url = "jdbc:mysql://localhost:3306/";
    protected String db = "architektury";
    protected String driver = "com.mysql.cj.jdbc.Driver";
    protected String user = "root";
    protected String pass = "password";

    protected Repository(String schemaPath) {
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            con = DriverManager.getConnection(url + db + "?characterEncoding=utf8", user, pass);
            Path sqlScriptPath = Paths.get(schemaPath);
            List<String> sqlList = Files.readAllLines(sqlScriptPath);
            String sqlJoined = String.join(" ", sqlList);
            for (String sql : sqlJoined.split(";")) {
                con.createStatement().execute(sql);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
