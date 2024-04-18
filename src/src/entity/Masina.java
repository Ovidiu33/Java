package entity;


import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Masina extends AbstractEntity implements Serializable {
    private String uniqueID = UUID.randomUUID().toString();
    private String marca;
    private String model;

    public Masina(String marca, String model) {
        this.uniqueID = UUID.randomUUID().toString(); // Generating unique ID
        this.marca = marca;
        this.model = model;
    }

    public Masina(String marca, String model,String uniqueID) {
        this.uniqueID = uniqueID;
        this.marca = marca;
        this.model = model;
    }


    public String getUniqueID() {
        return uniqueID;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Masina{" +
                "uniqueID='" + uniqueID + '\'' +
                ", nume='" + marca + '\'' +
                ", prenume='" + model + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Masina that = (Masina) o;
        return Objects.equals(uniqueID, that.uniqueID) && Objects.equals(marca, that.marca) && Objects.equals(model, that.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uniqueID, marca, model);
    }
}
