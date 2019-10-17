package service.impl;

import dao.SzereploDAO;
import filmespelda.exceptions.DateIsTooLate;
import filmespelda.exceptions.NoMatchingID;
import filmespelda.model.Szereplo;
import filmespelda.service.SzereploService;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import java.util.Collection;
import java.util.UUID;

public class SzereploServiceImplementation implements SzereploService {

    SzereploDAO dao;

    public SzereploServiceImplementation(SzereploDAO dao) {
        this.dao = dao;
    }

    public Collection<Szereplo> listAllSzereplo() {
        return dao.readAllSzereplo();
    }

    public Szereplo getSzereplo(UUID id) throws NoMatchingID {
        return dao.readSzereploById(id);
    }

    public void addSzereplo(Szereplo szereplo) throws DateIsTooLate, InvalidValue {
        dao.createSzereplo(szereplo);
    }

    public void updateSzereplo(Szereplo szereplo) throws DateIsTooLate, InvalidValue, NoMatchingID {
        dao.updateSzereplo(szereplo);
    }

    public void deleteSzereplo(Szereplo szereplo) throws NoMatchingID {
        dao.delete(szereplo);
    }

    public void deleteSzereplo(UUID id) throws NoMatchingID {
        Szereplo result = getSzereplo(id);
        deleteSzereplo(result);
    }
}
