public class Tauler {
    int numFiles;
    int numColumnes;

    public Tauler(int numFiles, int numColumnes) {
        this.numFiles = numFiles;
        this.numColumnes = numColumnes;
    }

    public int getNumFiles() {
        return numFiles;
    }

    public void setNumFiles(int numFiles) {
        this.numFiles = numFiles;
    }

    public int getNumColumnes() {
        return numColumnes;
    }

    public void setNumColumnes(int numColumnes) {
        this.numColumnes = numColumnes;
    }
}