package repository;
import entity.AbstractEntity;
import entity.Inchiriere;
import entity.Masina;

import java.io.IOException;
import java.util.*;

public class AbstractRepo<T extends AbstractEntity> {

    protected List<T> data = new ArrayList<>();

    public void add(T item) throws IOException {
        if(data.size() > 0 && data.get(0) instanceof Inchiriere)
            data.add(item);
        else
            data.add(item);
    }

    public Masina read(String id) {
        if (id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID-ul masinii nu poate fi gol.");
        }
        return (Masina) data.stream()
                .filter(m -> m.getUniqueID().equals(id))
                .findFirst()
                .orElse(null);
    }
    public void update(T newItem, String id) throws IOException {
        for (int i = 0; i < data.size(); i++) {
            T item = data.get(i);
            if (item instanceof AbstractEntity entity) {
                if (entity.getUniqueID().equals(id)) {
                    data.set(i, newItem);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("Item with ID " + id + " not found");
    }

    public void delete(String id) throws IOException {
        T itemToDelete = null;
        for (T item : data) {
            if (item instanceof AbstractEntity entity) {
                if (entity.getUniqueID().equals(id)) {
                    itemToDelete = item;
                    break;
                }
            }
        }

        if (itemToDelete != null) {
            data.remove(itemToDelete);
        } else {
            throw new IllegalArgumentException("Item with ID " + id + " not found");
        }
    }
    public boolean existsByID(String id) {
        for (T item : data) {
            if (item instanceof AbstractEntity entity) {
                if (entity.getUniqueID().equals(id)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Collection<T> getAll() {
        return new ArrayList<T>(data);
    }

    public Iterator<T> iterator() {
        return new ArrayList<T>(data).iterator();
    }
}