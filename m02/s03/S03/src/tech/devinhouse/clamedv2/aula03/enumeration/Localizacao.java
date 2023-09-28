package tech.devinhouse.clamedv2.aula03.enumeration;

public class Localizacao {

    private float latitude;

    private float longitude;

    private PontoCardeal pontoCardeal; // Norte sul leste oeste


    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public PontoCardeal getPontoCardeal() {
        return pontoCardeal;
    }

    public void setPontoCardeal(PontoCardeal pontoCardeal) {
        this.pontoCardeal = pontoCardeal;
    }
}
