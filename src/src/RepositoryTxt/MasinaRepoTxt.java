package RepositoryTxt;

import entity.Masina;
import repository.AbstractRepo;

import java.io.*;

public class MasinaRepoTxt extends AbstractRepo<Masina> {
    protected String filePath;

    public MasinaRepoTxt(String filePath) throws IOException {
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
                    String marca = parts[1];
                    String model = parts[2];
                    Masina item = new Masina( marca, model, uniqueID);
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
            for (Masina item : data) {
                String line = item.getUniqueID() + "," + item.getMarca() + "," + item.getModel() + ",";
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void add(Masina item) throws IOException {
        super.add(item);
        saveData();
    }
    public void update(Masina newItem, String id) throws IOException {
        super.update(newItem,id);
        saveData();
    }
    public void delete(String id) throws IOException {
        super.delete(id);
        saveData();
    }
}
