package models;

public class Puntuacion {
	    private int idpuntuacion;
	    private Equipo equipo1;
	    private Equipo equipo2;
	    private int puntuacion1;
	    private int puntuacion2;
	    private String observacion1;
	    private String observacion2;
	    private String penalizacion1;
	    private String penalizacion2;
		public int getIdpuntuacion() {
			return idpuntuacion;
		}
		public void setIdpuntuacion(int idpuntuacion) {
			this.idpuntuacion = idpuntuacion;
		}
		public Equipo getEquipo1() {
			return equipo1;
		}
		public void setEquipo1(Equipo equipo1) {
			this.equipo1 = equipo1;
		}
		public Equipo getEquipo2() {
			return equipo2;
		}
		public void setEquipo2(Equipo equipo2) {
			this.equipo2 = equipo2;
		}
		public int getPuntuacion1() {
			return puntuacion1;
		}
		public void setPuntuacion1(int puntuacion1) {
			this.puntuacion1 = puntuacion1;
		}
		public int getPuntuacion2() {
			return puntuacion2;
		}
		public void setPuntuacion2(int puntuacion2) {
			this.puntuacion2 = puntuacion2;
		}
		public String getObservacion1() {
			return observacion1;
		}
		public void setObservacion1(String observacion1) {
			this.observacion1 = observacion1;
		}
		public String getObservacion2() {
			return observacion2;
		}
		public void setObservacion2(String observacion2) {
			this.observacion2 = observacion2;
		}
		public String getPenalizacion1() {
			return penalizacion1;
		}
		public void setPenalizacion1(String penalizacion1) {
			this.penalizacion1 = penalizacion1;
		}
		public String getPenalizacion2() {
			return penalizacion2;
		}
		public void setPenalizacion2(String penalizacion2) {
			this.penalizacion2 = penalizacion2;
		}
		public Puntuacion(int idpuntuacion, Equipo equipo1, Equipo equipo2, int puntuacion1, int puntuacion2,
				String observacion1, String observacion2, String penalizacion1, String penalizacion2) {
			super();
			this.idpuntuacion = idpuntuacion;
			this.equipo1 = equipo1;
			this.equipo2 = equipo2;
			this.puntuacion1 = puntuacion1;
			this.puntuacion2 = puntuacion2;
			this.observacion1 = observacion1;
			this.observacion2 = observacion2;
			this.penalizacion1 = penalizacion1;
			this.penalizacion2 = penalizacion2;
		}

	}

