import RepositoryTxt.MasinaRepoTxt;
import RepositoryTxt.InchiriereRepoTxt;
import UI.UI;
import configReader.ConfigReader;
import entity.Inchiriere;
import entity.Masina;
import repositoryBin.RepoBin;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws IOException {
        ConfigReader configReader = new ConfigReader();
        Map<String,String> config = configReader.config();
        if(Objects.equals(config.get("Repository"), "binary")) {
            RepoBin<Masina> repoMasina = new RepoBin<Masina> (config.get("Masini"));
            RepoBin<Inchiriere> repoInchiriere= new RepoBin<Inchiriere>(config.get("Inchirieri"));
            UI ui = new UI(repoMasina, repoInchiriere);
            ui.ui();
        }
        else if(Objects.equals(config.get("Repository"), "text")) {
            MasinaRepoTxt repoMasina = new MasinaRepoTxt(config.get("Masini"));
            InchiriereRepoTxt repoInchiriere = new InchiriereRepoTxt(config.get("Inchirieri"));
            UI ui = new UI(repoMasina, repoInchiriere);
            ui.ui();
        }
        else
            System.out.println("Nu exista un astfel de Repo!");
    }
}