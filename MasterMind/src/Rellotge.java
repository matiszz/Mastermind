public class Rellotge{
    int hores;
    int minuts;
    int segons;
    int milisegons;

    void iniciar_rellotge() {
        // start chrono
    }

    void continuar_rellotge(int hores, int minuts, int segons, int milisegons) {
        // continuar rellotge
    }

    String aturar_rellotge() {
        // stop chrono
        return ""+hores+':'+minuts+':'+segons+':'+milisegons;
    }


    String getTime() {
        return ""+hores+':'+minuts+':'+segons+':'+milisegons;
    }
}