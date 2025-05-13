package controler;

import dao.FasesporEquipo;
import dao.JDBCDaoEquipo;
import dao.JDBCDaoPuntuacion;

public class Pruebasql {

	public static void main(String[] args) {
		/*try {
		JDBCDaoPuntuacion p = new JDBCDaoPuntuacion();
		System.out.println(p.listarParticipantes(0, 1));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
		/*try {
		JDBCDaoPuntuacion p = new JDBCDaoPuntuacion();
		System.out.println(p.devuelveSiMejorOrador(2));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}*/
		try {
			JDBCDaoPuntuacion p = new JDBCDaoPuntuacion();
			p.insertaPuntuacion(1,2,100,200,"Nada","Nada","Nada","Nada",FasesporEquipo.PrimeraFase,1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*try {
			JDBCDaoEquipo p = new JDBCDaoEquipo();
			p.insertaEquipo();
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
		/*try {
			JDBCDaoEquipo p = new JDBCDaoEquipo();
			p.actualizaDatos(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}

}
