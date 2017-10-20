public class Rellotge{
    int begin;
    int end;

    public void iniciar_rellotge() {
        begin = System.currentTimeMillis();
    }

    public void continuar_rellotge(int time) {
        begin = time;
    }

    public String aturar_rellotge() {
        end = System.currentTimeMillis();
        int ellapsed = end - begin;
        int milliseconds, seconds, minutes, hours;

        hours = ellapsed/3600000.0;
    }


    public String getTime() {
        return ""+hores+':'+minuts+':'+segons+':'+milisegons;
    }
}