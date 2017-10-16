public class Partida {
    int idPartida;
    String mode;
    int temps;
    int numJugades;
    int puntuacio;
    boolean estat;

    public Partida(int idPartida, String mode, int temps, int numJugades, int puntuacio, boolean estat) {
        this.idPartida = idPartida;
        this.mode = mode;
        this.temps = temps;
        this.numJugades = numJugades;
        this.puntuacio = puntuacio;
        this.estat = estat;
    }
    // jugarParida(idPartida);

    public int getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(int idPartida) {
        this.idPartida = idPartida;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public int getNumJugades() {
        return numJugades;
    }

    public void setNumJugades(int numJugades) {
        this.numJugades = numJugades;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public boolean getEstat() {
        return estat;
    }

    public void setEstat(boolean estat) {
        this.estat = estat;
    }
}