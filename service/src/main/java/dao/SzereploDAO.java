package dao;

import filmespelda.model.Szereplo;

import java.util.Collection;
import java.util.UUID;

public interface SzereploDAO {
    public void createSzereplo(Szereplo szereplo);

    public Collection<Szereplo> readAllSzereplo();

    public void updateSzereplo(Szereplo szereplo);

    public void delete(Szereplo szereplo);

    public Szereplo readSzereploById(UUID id);


}