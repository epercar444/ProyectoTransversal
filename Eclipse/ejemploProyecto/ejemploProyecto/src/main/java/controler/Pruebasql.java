package controler;

import dao.JDBCDaoEquipo;

public class Pruebasql {

	public static void main(String[] args) {
		/*try {
			JDBCDaoEquipo p = new JDBCDaoEquipo();
			p.insertaEquipo(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
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
		try {
			JDBCDaoEquipo p = new JDBCDaoEquipo();
			p.actualizaDatos(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
