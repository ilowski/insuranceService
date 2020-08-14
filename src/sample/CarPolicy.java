package sample;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class CarPolicy extends RecursiveTreeObject<CarPolicy> {
    StringProperty nrPolicy;
    StringProperty name;
    StringProperty surname;
    StringProperty pesel;
    StringProperty address;
    StringProperty typePolicy;
    StringProperty startDatePolicy;
    StringProperty endDatePolicy;
    StringProperty registrationNr;
    StringProperty mark;
    StringProperty model;


    public CarPolicy() {
        super();
    }

    public CarPolicy(String registrationNr, String nrPolicy, String name, String surname, String pesel, String address, String startDatePolicy, String endDatePolicy, String model, String mark, String typePolicy) {
        this.nrPolicy = new SimpleStringProperty(nrPolicy);
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.pesel = new SimpleStringProperty(pesel);
        this.address = new SimpleStringProperty(address);
        this.typePolicy = new SimpleStringProperty(typePolicy);
        this.startDatePolicy = new SimpleStringProperty(startDatePolicy);
        this.endDatePolicy = new SimpleStringProperty(endDatePolicy);
        this.registrationNr = new SimpleStringProperty(registrationNr);
        this.mark = new SimpleStringProperty(mark);
        this.model = new SimpleStringProperty(model);
    }
}
