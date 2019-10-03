package service.impl;

import filmespelda.exceptions.DateIsTooLate;
import filmespelda.exceptions.NoMatchingID;
import filmespelda.model.Szereplo;
import filmespelda.service.SzereploService;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import java.util.Collection;
import java.util.UUID;

public class SzereploServiceImplementation implements SzereploService {
    public Collection<Szereplo> listAllSzereplo() {
        return null;
    }

    public Szereplo getSzereplo(UUID id) throws NoMatchingID {
        return null;
    }

    public void addSzereplo(Szereplo szereplo) throws DateIsTooLate, InvalidValue {

    }

    public void updateSzereplo(Szereplo szereplo) throws DateIsTooLate, InvalidValue, NoMatchingID {

    }

    public void deleteSzereplo(Szereplo szereplo) throws NoMatchingID {

    }

    public void deleteSzereplo(UUID id) throws NoMatchingID {

    }
}
