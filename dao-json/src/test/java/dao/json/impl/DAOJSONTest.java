package dao.json.impl;


import dao.SzereploDAO;
import filmespelda.model.Szereplo;
import org.junit.Test;

class DAOJSONTest{

    @Test
    void createSzereplo() {
        SzereploDAO dao = new DAOJSON("kiscica.json");
        Szereplo szereplo = new Szereplo();
        szereplo.setKarakter_neve("KISCICA");
        dao.createSzereplo(szereplo);
    }
}