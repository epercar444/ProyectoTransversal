package controler;

import dao.JDBCDaoPuntuacion;

public class Pruebasql {

	public static void main(String[] args) {
		try {
			JDBCDaoPuntuacion p = new JDBCDaoPuntuacion();
			p.insertaPuntuacion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			JDBCDaoEquipo p = new JDBCDaoEquipo();
			p.eliminaEquipo(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			JDBCDaoEquipo p = new JDBCDaoEquipo();
			System.out.println(p.consultaEquipo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		/*try {
			JDBCDaoEquipo p = new JDBCDaoEquipo();
			p.actualizaDatos(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
