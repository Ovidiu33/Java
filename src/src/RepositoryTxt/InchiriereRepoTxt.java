package RepositoryTxt;

import entity.Inchiriere;
import repository.AbstractRepo;

import java.io.*;
import java.time.LocalDate;

public class InchiriereRepoTxt extends AbstractRepo<Inchiriere> {
    protected String filePath;

    public InchiriereRepoTxt(String filePath) throws IOException {
        this.filePath = filePath;
        loadData();
    }

    private void loadData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String uniqueID = parts[0];
                    LocalDate dataInceput = LocalDate.parse(parts[1]);
                    LocalDate dataSfarsit = LocalDate.parse(parts[2]);
                    Inchiriere item = new Inchiriere(dataInceput, dataSfarsit, uniqueID);
                    if (item != null) {
                        data.add(item);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Inchiriere item : data) {
                String line = item.getUniqueID() + "," + item.getDataInceput() + "," + item.getDataSfarsit()  + ","+item.getIdInchiriere();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Inchiriere item) throws IOException {
        super.add(item);
        saveData();
    }
    public void update(Inchiriere newItem, String id) throws IOException {
        super.update(newItem,id);
        saveData();
    }
    public void delete(String id) throws IOException {
        super.delete(id);
        saveData();
    }
}
