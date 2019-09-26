package filmespelda.model;

import filmespelda.exceptions.DateIsTooLate;

import java.time.LocalDate;
import java.util.UUID;

public class Ember {
    private UUID id;
    private String vezeteknev;
    private String keresztnev;
    private LocalDate szuletesi_datum;


    public Ember() {
        this.id = UUID.randomUUID();
    }

    public Ember(String vezeteknev, String keresztnev,
                 LocalDate szuletesi_datum) throws DateIsTooLate {
        this.id = UUID.randomUUID();
        this.vezeteknev = vezeteknev;
        this.keresztnev = keresztnev;
        setSzuletesi_datum(szuletesi_datum);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getVezeteknev() {
        return vezeteknev;
    }

    public void setVezeteknev(String vezeteknev) {
        this.vezeteknev = vezeteknev;
    }

    public String getKeresztnev() {
        return keresztnev;
    }

    public void setKeresztnev(String keresztnev) {
        this.keresztnev = keresztnev;
    }

    public LocalDate getSzuletesi_datum() {
        return szuletesi_datum;
    }

    public void setSzuletesi_datum(LocalDate szuletesi_datum) throws DateIsTooLate {
        if (!szuletesi_datum.isBefore(LocalDate.now())) {
            throw new DateIsTooLate(szuletesi_datum.toString());
        }
        this.szuletesi_datum = szuletesi_datum;

    }
}
