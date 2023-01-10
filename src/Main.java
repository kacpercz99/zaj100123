public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        person.readData("kacper","czura","99072100010");
        System.out.println(person);
    }

    public static boolean isLargerThan(String imie, String naziwsko, String zawod, int maxLength){
        return (imie.length() > maxLength || naziwsko.length() > maxLength || zawod.length() > maxLength);
    }

    public static int containsPrefix(String[] strings, String prefix) {
        int counter = 0;
        for (String string : strings) {
            if(string.startsWith(prefix)) counter++;
        }
        return counter;
    }
    public static int contains(String[] strings, String word, boolean checkForPrefix){
        if(checkForPrefix) {
            return containsPrefix(strings,word);
        }
        int counter = 0;
        for(String string : strings) {
            if(string.endsWith(word)) counter++;
        }
        return counter;
    }

    public static String wytnijTekst(String tekst, int poczatek, int koniec){
        if(poczatek < 1 || koniec < 1) throw new IllegalArgumentException();
        String substr = tekst.substring(poczatek,koniec);
        return tekst
                .concat("Zakres wyciniania: ")
                .concat(String.valueOf(poczatek))
                .concat(String.valueOf(koniec))
                .concat("Wynik wycinania: ")
                .concat(substr)
                .concat("Dlugosc wycietego ciagu")
                .concat(String.valueOf(substr.length()));
    }
}
