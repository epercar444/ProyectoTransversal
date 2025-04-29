package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCDaoPuntuacion extends JdbcDao{

	public JDBCDaoPuntuacion() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}
	public void insertaPuntuacion() {
		String query = "INSERT INTO puntuacion (idequipo1, idequipo2, puntuacion1, puntuacion2, observacion1, observacion2, penalizacion1, penalizacion2) VALUES (3, 10, 98, 102,'Uso excelente de recursos visuales', 'Explicación técnica precisa', 'Ninguna', 'Error menor en datos')";
		Connection conn = null;
		Statement stmt = null;
		// si mejor orador: listar participantes
		try {
			conn = this.getConnection(); // Método para obtener la conexión
			stmt = conn.createStatement();
			stmt.execute(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		
	}
}
