package repository;

import dao.JDBCDaoPuntuacion;
import models.Equipo;

public class repositorioPuntuacion {
	public void altaPuntuacion() throws Exception {
		   JDBCDaoPuntuacion p = new JDBCDaoPuntuacion();
		   p.insertaPuntuacion();
	}
}
