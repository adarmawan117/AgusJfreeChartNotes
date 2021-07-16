package Method;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    
    protected final String MYSQL_URL    = "jdbc:mysql://localhost:3306/sellin";
    protected final String MYSQL_DRIVER = "com.mysql.cj.jdbc.Driver";
    protected final String USERNAME     = "root";
    protected final String PASSWORD     = "";
    
    protected Statement STATEMENT = null;
    protected PreparedStatement PREPARED_STMT = null;
    protected Connection CONN = null;
    protected ResultSet RS;
    protected Dialog dialog = new Dialog();
    
}
