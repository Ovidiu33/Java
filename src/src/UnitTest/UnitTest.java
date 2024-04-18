package UnitTest;
import entity.Inchiriere;
import entity.Masina;
import org.junit.Test;

import repository.AbstractRepo;
import service.MasinaService;
import service.InchiriereService;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class UnitTest {

    AbstractRepo<Masina> masinaRepo= new AbstractRepo<Masina>();
    AbstractRepo<Inchiriere> inchiriereRepo = new AbstractRepo<>();
    MasinaService masinaService = new MasinaService(masinaRepo);
    InchiriereService inchiriereService = new InchiriereService(inchiriereRepo);
    Masina masina1 = new Masina("ford","mustang", "1234");
    Inchiriere inchiriere1 = new Inchiriere("1234","2023-12-20","2023-12-21",masina1.getUniqueID());
    public UnitTest() throws IOException {
        this.masinaService.add(masina1);
        this.inchiriereService.add(inchiriere1);
    }

    @Test
    public void TestAdd() {
        assertEquals(1, masinaService.getAll().size());
        assertEquals(1, inchiriereService.getAll().size());
    }

    @Test
    public void TestUpdate() throws IOException {
        Masina masina2 = new Masina("b", "b", "1");
        masinaService.update(masina2, masina1.getUniqueID());
        Inchiriere inchiriere2 = new Inchiriere("125","2023-12-22","2023-12-25", masina2.getUniqueID());
        inchiriereService.update(inchiriere2, inchiriere1.getUniqueID());
        ArrayList<Masina> masinaList = (ArrayList<Masina>) masinaService.getAll();
        ArrayList<Inchiriere> inchirieriList = (ArrayList<Inchiriere>) inchiriereService.getAll();
        assertEquals("b", masinaList.get(0).getMarca());
        assertEquals("b", masinaList.get(0).getModel());
        assertEquals("2023-12-22", inchirieriList.get(0).getDataInceput());
        assertEquals("2023-12-25", inchirieriList.get(0).getDataSfarsit());
    }

    @Test
    public void TestDelete() throws IOException {
        inchiriereService.delete(inchiriere1.getUniqueID());
        masinaService.delete(masina1.getUniqueID());
        assertEquals(0, masinaService.getAll().size());
        assertEquals(0, inchiriereService.getAll().size());
    }
    private int result(){
        return 5;
    }
}
