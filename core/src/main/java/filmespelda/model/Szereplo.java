package filmespelda.model;

import filmespelda.exceptions.DateIsTooLate;

import java.time.LocalDate;

public class Szereplo extends Ember {
    private String karakter_neve;

    public Szereplo(){

    }

    public Szereplo(String vezeteknev, String keresztnev,
                    LocalDate szuletesi_datum, String karakter_neve)
            throws DateIsTooLate {
        super(vezeteknev, keresztnev, szuletesi_datum);
        this.karakter_neve = karakter_neve;
    }



    public String getKarakter_neve() {
        return karakter_neve;
    }

    public void setKarakter_neve(String karakter_neve) {
        this.karakter_neve = karakter_neve;
    }



}
