package filmespelda.model;

import filmespelda.exceptions.DateIsTooLate;
import org.omg.DynamicAny.DynAnyPackage.InvalidValue;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

public class Film {
    private int hossz;
    private String magyar_cim;
    private String eredeti_cim;
    /**
     * List mert fontos a sorrend.
     */
    private List<Szereplo> szereplok;
    private Collection<Rendezo> rendezok;
    private Collection<Mufaj> mufajok;
    private LocalDate megjelenes_datuma;
    private Besorolas besorolas;
    private double imdb_pont;


    public Film() {
    }

    public Film(int hossz, String magyar_cim, String eredeti_cim,
                List<Szereplo> szereplok, Collection<Rendezo> rendezok,
                Collection<Mufaj> mufajok, LocalDate megjelenes_datuma,
                Besorolas besorolas, double imdb_pont)
            throws InvalidValue, DateIsTooLate {
        setHossz(hossz);
        this.magyar_cim = magyar_cim;
        this.eredeti_cim = eredeti_cim;
        this.szereplok = szereplok;
        this.rendezok = rendezok;
        this.mufajok = mufajok;
        setMegjelenes_datuma(megjelenes_datuma);
        this.besorolas = besorolas;
        setImdb_pont(imdb_pont);
    }

    public int getHossz() {
        return hossz;
    }

    public void setHossz(int hossz) throws InvalidValue {
        if (hossz < 1) {
            throw new InvalidValue();
        }
        this.hossz = hossz;
    }

    public String getMagyar_cim() {
        return magyar_cim;
    }

    public void setMagyar_cim(String magyar_cim) {
        this.magyar_cim = magyar_cim;
    }

    public String getEredeti_cim() {
        return eredeti_cim;
    }

    public void setEredeti_cim(String eredeti_cim) {
        this.eredeti_cim = eredeti_cim;
    }

    public List<Szereplo> getSzereplok() {
        return szereplok;
    }

    public void setSzereplok(List<Szereplo> szereplok) {
        this.szereplok = szereplok;
    }

    public Collection<Rendezo> getRendezok() {
        return rendezok;
    }

    public void setRendezok(Collection<Rendezo> rendezok) {
        this.rendezok = rendezok;
    }

    public Collection<Mufaj> getMufajok() {
        return mufajok;
    }

    public void setMufajok(Collection<Mufaj> mufajok) {
        this.mufajok = mufajok;
    }

    public LocalDate getMegjelenes_datuma() {
        return megjelenes_datuma;
    }

    public void setMegjelenes_datuma(LocalDate megjelenes_datuma)
            throws DateIsTooLate {
        if (!megjelenes_datuma.isBefore(LocalDate.now().plusMonths(3))) {
            throw new DateIsTooLate(megjelenes_datuma.toString());
        }
        this.megjelenes_datuma = megjelenes_datuma;
    }

    public Besorolas getBesorolas() {
        return besorolas;
    }

    public void setBesorolas(Besorolas besorolas) {
        this.besorolas = besorolas;
    }

    public double getImdb_pont() {
        return imdb_pont;
    }

    public void setImdb_pont(double imdb_pont) throws InvalidValue {
        if (imdb_pont < 0.0 || imdb_pont > 10.0) {
            throw new InvalidValue();
        }
        this.imdb_pont = imdb_pont;
    }
}
