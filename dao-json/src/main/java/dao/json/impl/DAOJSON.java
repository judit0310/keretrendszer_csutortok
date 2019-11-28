package dao.json.impl;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sun.tracing.dtrace.ArgsAttributes;
import dao.SzereploDAO;
import filmespelda.exceptions.NoMatchingID;
import filmespelda.model.Szereplo;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.File;
import java.io.FileWriter;
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
                FileWriter writer = new FileWriter(jsonFile);
                writer.write("[]");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mapper= new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);

    }

    public DAOJSON(String jsonFilePath) {
        this.jsonFile = new File(jsonFilePath);
        if (!jsonFile.exists()){
            try {
                jsonFile.createNewFile();
                FileWriter writer = new FileWriter(jsonFile);
                writer.write("[]");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT);
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

    public void delete(Szereplo szereplo) throws NoMatchingID {
        Collection<Szereplo> szereplok =readAllSzereplo();
        Collection<Szereplo> result= new ArrayList<>();
        try {
            Szereplo torlendo = readSzereploById(szereplo.getId());
            for(Szereplo sz : szereplok){
                if(! (sz.getId() == torlendo.getId())){
                    result.add(sz);
                }
            }
            mapper.writeValue(jsonFile, result);
        } catch (NoMatchingID noMatchingID) {
            throw noMatchingID;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Szereplo readSzereploById(UUID id) throws NoMatchingID {
        Collection<Szereplo> szereplok =readAllSzereplo();
        for (Szereplo sz: szereplok){
            if (sz.getId().toString().equalsIgnoreCase(id.toString())){
                return sz;
            }
        }
        throw new NoMatchingID();
    }
}
