import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String imie;
    private String nazwisko;
    private String pesel;
    private int wiek;
    private String dataUrodzenia;
    private char plec;

    public void readData(String imie, String nazwisko, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        setDataUrodzeniaFromPesel();
        setWiekFromDataUrodzenia();
        setPlecFromPesel();
    }

    private void setDataUrodzeniaFromPesel() {
        String yearPrefix;
        if (Integer.parseInt(pesel.substring(0, 2)) >= 40) {
            yearPrefix = "19";
        } else {
            yearPrefix = "20";
        }
        dataUrodzenia = yearPrefix
                .concat(pesel.substring(0, 2))
                .concat("-")
                .concat(pesel.substring(2, 4))
                .concat("-")
                .concat(pesel.substring(4, 6));
    }

    private void setWiekFromDataUrodzenia() {
        wiek = Period.between(LocalDate.parse(dataUrodzenia), LocalDate.now()).getYears();
    }

    private void setPlecFromPesel() {
        if (Integer.parseInt(String.valueOf(pesel.charAt(9))) % 2 == 0) plec = 'k';
        else plec = 'm';
    }

    @Override
    public String toString() {
        return "Person{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", pesel='" + pesel + '\'' +
                ", wiek=" + wiek +
                ", dataUrodzenia='" + dataUrodzenia + '\'' +
                ", plec=" + plec +
                '}';
    }
}
