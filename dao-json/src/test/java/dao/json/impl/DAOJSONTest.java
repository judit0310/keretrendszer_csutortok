package dao.json.impl;


import dao.SzereploDAO;
import filmespelda.exceptions.DateIsTooLate;
import filmespelda.model.Szereplo;
import org.junit.Test;

import java.time.LocalDate;

public class DAOJSONTest{

    @Test
    public void createSzereplo() throws DateIsTooLate {
        SzereploDAO dao = new DAOJSON("kiscica.json");
        Szereplo szereplo = new Szereplo();
        szereplo.setKarakter_neve("KISCICA");
        szereplo.setSzuletesi_datum(LocalDate.of(1988, 05, 24));
        dao.createSzereplo(szereplo);
    }
}