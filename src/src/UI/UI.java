package UI;

import entity.Inchiriere;
import entity.Masina;
import repository.AbstractRepo;
import service.MasinaService;
import service.InchiriereService;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Objects;
import java.util.Scanner;

public class UI {
    Scanner scanner = new Scanner(System.in);
    MasinaService masinaService;
    InchiriereService inchiriereService;
    AbstractRepo<Masina> masinaRepo;
    AbstractRepo<Inchiriere> inchiriereRepo;

    public UI(AbstractRepo<Masina> masinaRepo, AbstractRepo<Inchiriere> inchiriereRepo) {
        this.masinaRepo = masinaRepo;
        this.inchiriereRepo = inchiriereRepo;
        this.masinaService = new MasinaService(masinaRepo);
        this.inchiriereService = new InchiriereService(inchiriereRepo);
    }
    private void in_memory() throws IOException {
        Masina m1=new Masina("ford","mustang");
        Masina m2=new Masina("Audi","A5");
        Masina m3=new Masina("Audi","A3");
        Masina m4=new Masina("Audi","A6");
        Masina m5=new Masina("Audi","A8");
        masinaService.add(m1);
        masinaService.add(m2);
        masinaService.add(m3);
        masinaService.add(m4);
        masinaService.add(m5);
    }

    public void ui() throws IOException {
        in_memory();
        try {
            int option = 1;
            while (option != 0) {
                System.out.println(menuPrint());
                option = scanner.nextInt();
                switch (option) {
                    case 0: {
                        option = 0;
                        break;
                    }
                    case 1: {
                        addMasina();
                        break;
                    }
                    case 2: {
                        addInchiriere();
                        break;
                    }
                    case 3: {
                        updateMasina();
                        break;
                    }
                    case 4: {
                        updateInchiriere();
                        break;
                    }
                    case 5: {
                        deleteMasina();
                        break;
                    }
                    case 6: {
                        deleteInchiriere();
                        break;
                    }
                    case 7: {
                        printMasina();
                        break;
                    }
                    case 8: {
                        printInchiriere();
                        break;
                    }
                    default: {
                        System.out.println("Invalid command!");
                    }
                }
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println("Invalid!");
            scanner.next();
        } catch (Exception e) {
            System.out.println("Eroare " + e.getMessage());
        }
    }


    public static String menuPrint() {
        return ("Meniu: \n " +'\n'+
                "0. Exit\n" +
                "1. Adauga Masina\n" +
                "2. Adauga Inchiriere\n" +
                "3. Modifica Masina\n" +
                "4. Modifica Inchirierea\n" +
                "5. Sterge Masina\n" +
                "6. Sterge Inchirierea\n" +
                "7. Afiseaza Masinile\n" +
                "8. Afiseaza Inchirierile\n" +'\n'+
                "Selecteaza o optiune:");
    }
    public void addMasina() throws IOException {
        System.out.println("marca: ");
        String marca = scanner.next();
        System.out.println("model: ");
        String model = scanner.next();
        Masina masina = new Masina(marca, model);
        masinaService.add(masina);
    }

    public void addInchiriere() throws IOException {
        System.out.print("Introduceti ID-ul masinii pentru inchiriere: ");
        String carId = scanner.nextLine();
        carId = scanner.nextLine();

        System.out.print("Introduceti data de inceput a inchirierii (YYYY-MM-DD): ");
        String dataInceputStr = scanner.nextLine();
        LocalDate dataInceput = LocalDate.parse(dataInceputStr);

        System.out.print("Introduceti data de sfarsit a inchirierii (YYYY-MM-DD): ");
        String dataSfarsitStr = scanner.nextLine();
        LocalDate dataSfarsit = LocalDate.parse(dataSfarsitStr);

        Inchiriere inchiriere = new Inchiriere(dataInceput, dataSfarsit, carId);
        inchiriereService.add(inchiriere);
    }

    public void updateInchiriere() throws IOException {
        System.out.print("Introduceti ID-ul masinii pentru modificare inchiriere: ");
        String carId = scanner.nextLine();
        carId = scanner.nextLine();

        System.out.print("Introduceti data de inceput a inchirierii (YYYY-MM-DD): ");
        String dataInceputStr = scanner.nextLine();
        LocalDate dataInceput = LocalDate.parse(dataInceputStr);

        System.out.print("Introduceti data de sfarsit a inchirierii (YYYY-MM-DD): ");
        String dataSfarsitStr = scanner.nextLine();
        LocalDate dataSfarsit = LocalDate.parse(dataSfarsitStr);

        Inchiriere inchiriere = new Inchiriere(dataInceput, dataSfarsit, carId);
        inchiriereService.update(inchiriere, carId);
    }

    public void updateMasina() throws IOException {
        System.out.println("id masina: ");
        String id = scanner.next();
        System.out.println("marca: ");
        String marca = scanner.next();
        System.out.println("model: ");
        String model = scanner.next();
        Masina masina = new Masina(marca, model);
        masinaService.update(masina, id);
    }

    public void deleteInchiriere() throws IOException {
        System.out.println("id programare: ");
        String id = scanner.next();
        inchiriereService.delete(id);
    }

    public void deleteMasina() throws IOException {
        System.out.println("id Masina: ");
        String id = scanner.next();
        masinaService.delete(id);
    }

    public void printInchiriere() {
        Collection<Inchiriere> list= inchiriereService.getAll();
        for(Inchiriere inchiriere : list)
            System.out.println(inchiriere.toString());
    }

    public void printMasina() {
        Collection<Masina> list = masinaService.getAll();
        for(Masina masina : list)
            System.out.println(masina.toString());
    }

    public boolean existMasina(String id) {
        Collection<Masina> masinaList = masinaService.getAll();
        for(Masina masina : masinaList)
            if(Objects.equals(masina.getUniqueID(), id))
                return true;
        return false;
    }
}