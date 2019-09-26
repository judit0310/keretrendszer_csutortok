package filmespelda.service;

import filmespelda.exceptions.DateIsTooLate;
import filmespelda.exceptions.NoMatchingID;
import filmespelda.model.Szereplo;
import org.omg.CORBA.DynAnyPackage.InvalidValue;

import java.util.Collection;
import java.util.UUID;

public interface SzereploService {
    public Collection<Szereplo> listAllSzereplo();
    public Szereplo getSzereplo(UUID id) throws NoMatchingID;
    public void addSzereplo(Szereplo szereplo) throws DateIsTooLate, InvalidValue;
    public void updateSzereplo(Szereplo szereplo) throws DateIsTooLate, InvalidValue, NoMatchingID;
    public void deleteSzereplo(Szereplo szereplo) throws NoMatchingID;
    public void deleteSzereplo(UUID id) throws NoMatchingID;

}
