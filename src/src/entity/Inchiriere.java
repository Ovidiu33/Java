package entity;

import javax.ejb.Local;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Inchiriere extends AbstractEntity implements Serializable {
    private String uniqueID = UUID.randomUUID().toString();
    private LocalDate dataInceput;
    private LocalDate dataSfarsit;
    private String idInchiriere;

    public Inchiriere(String uniqueID, LocalDate dataInceput, LocalDate dataSfarsit, String idInchiriere) {
        this.uniqueID = uniqueID;
        this.dataInceput = dataInceput;
        this.dataSfarsit = dataSfarsit;
        this.idInchiriere = idInchiriere;
    }
    public Inchiriere(LocalDate dataInceput, LocalDate dataSfarsit, String idInchiriere) {
        this.uniqueID = UUID.randomUUID().toString();
        this.dataInceput = dataInceput;
        this.dataSfarsit = dataSfarsit;
        this.idInchiriere = idInchiriere;
    }

    public Inchiriere(String number, String date, String date1, String number1) {
        super();
    }

    @Override
    public String getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public LocalDate getDataInceput() {
        return dataInceput;
    }

    public void setDataInceput(LocalDate dataInceput) {
        this.dataInceput = dataInceput;
    }

    public LocalDate getDataSfarsit() {
        return dataSfarsit;
    }

    public void setDataSfarsit(LocalDate dataSfarsit) {
        this.dataSfarsit = dataSfarsit;
    }

    public String getIdInchiriere() {
        return idInchiriere;
    }

    public void setIdInchiriere(String idInchiriere) {
        this.idInchiriere = idInchiriere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inchiriere that)) return false;
        return Objects.equals(getUniqueID(), that.getUniqueID()) && Objects.equals(getDataInceput(), that.getDataInceput()) && Objects.equals(getDataSfarsit(), that.getDataSfarsit()) && Objects.equals(getIdInchiriere(), that.getIdInchiriere());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUniqueID(), getDataInceput(), getDataSfarsit(), getIdInchiriere());
    }

    @Override
    public String toString() {
        return "Inchiriere{" +
                "uniqueID='" + uniqueID + '\'' +
                ", dataInceput=" + dataInceput +
                ", dataSfarsit=" + dataSfarsit +
                ", idInchiriere='" + idInchiriere + '\'' +
                '}';
    }
}
