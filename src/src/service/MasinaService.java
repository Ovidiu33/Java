package service;

import entity.Masina;
import repository.AbstractRepo;

import java.io.IOException;
import java.util.Collection;

public class MasinaService {
    private AbstractRepo<Masina> repo;

    public MasinaService(AbstractRepo<Masina> repo) {
        this.repo = repo;
    }

    public void add(Masina item) throws IOException {
        this.repo.add(item);
    }

    public void update(Masina item, String id) throws IOException {
        this.repo.update(item, id);
    }

    public void delete(String index) throws IOException {
        this.repo.delete(index);
    }

    public Collection<Masina> getAll() {
        return this.repo.getAll();
    }

}
