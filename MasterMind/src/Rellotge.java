/* Clase hecha por Mati */

public class Rellotge{
    int begin;
    int end;
    int ellapsed;

    /*
        Inicia el rellotge.
        <- Retorna 1 per indicar que ha sigut correcte.
     */
    public void iniciar_rellotge() {
        begin = System.currentTimeMillis();
        return 1;
    }

    /*
        Continua el rellotge.
        -> Se li passa com a paràmetre el temps en millisegons.
        <- Retorna 1 per indicar que ha sigut correcte.
     */
    public void continuar_rellotge(int time) {
        begin = time;
        return 1;
    }

    /*
        Atura el rellotge.
        <- Retorna el temps en millisegons.
     */
    public String aturar_rellotge() {
        end = System.currentTimeMillis();
        ellapsed = end - begin;
        return ellapsed;
    }

    /*
        Retorna el temps guardat.
        <- El retorna un string amb el temps en format hh:mm:ss
     */
    public String getTime() {
        String hhmmss = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(ellapsed),
                TimeUnit.MILLISECONDS.toMinutes(ellapsed) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(ellapsed)),
                TimeUnit.MILLISECONDS.toSeconds(ellapsed) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(ellapsed)));
        return hhmmss;
    }
}