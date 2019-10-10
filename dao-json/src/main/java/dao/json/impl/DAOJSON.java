package dao.json.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import dao.SzereploDAO;
import filmespelda.model.Szereplo;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class DAOJSON implements SzereploDAO {

    File jsonFile;
    ObjectMapper mapper ;

    public DAOJSON(File jsonFile) {
        this.jsonFile = jsonFile;
        if (!jsonFile.exists()){
            try {
                jsonFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mapper= new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

    }

    public DAOJSON(String jsonFilePath) {
        this.jsonFile = new File(jsonFilePath);
        if (!jsonFile.exists()){
            try {
                jsonFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    public void createSzereplo(Szereplo szereplo) {
        Collection<Szereplo> szereplok = readAllSzereplo();
        szereplok.add(szereplo);
        try {
            mapper.writeValue(jsonFile, szereplok);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Collection<Szereplo> readAllSzereplo() {
        Collection<Szereplo> result = new ArrayList<Szereplo>();
        try {
            result = mapper.readValue(jsonFile,
                    new TypeReference<ArrayList<Szereplo>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void updateSzereplo(Szereplo szereplo) {

    }

    public void delete(Szereplo szereplo) {

    }

    public Szereplo readSzereploById(UUID id) {
        return null;
    }
}
