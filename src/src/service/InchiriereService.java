package service;

import entity.Inchiriere;
import entity.Masina;
import repository.AbstractRepo;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;

public class InchiriereService {
    private AbstractRepo<Inchiriere> repo;

    public InchiriereService(AbstractRepo<Inchiriere> repo) {
        this.repo = repo;
    }

    public void add(Inchiriere item) throws IOException {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null.");
        }
        LocalDate currentDate = LocalDate.now();
        if (item.getDataInceput().isBefore(currentDate)) {
            throw new IllegalArgumentException("Data de început trebuie să fie în viitor.");
        }
        if (item.getDataSfarsit().isBefore(item.getDataInceput())) {
            throw new IllegalArgumentException("Data de sfârșit trebuie să fie după data de început.");
        }
        repo.add(item);
    }
    public void update(Inchiriere item, String id) throws IOException {
        this.repo.update(item, id);
    }

    public void delete(String index) throws IOException {
        this.repo.delete(index);
    }

    public Collection<Inchiriere> getAll() {
        return this.repo.getAll();
    }
}
