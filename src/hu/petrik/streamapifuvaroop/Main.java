package hu.petrik.streamapifuvaroop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
   private  static List<Fuvar> fuvarok;

    public static void main(String[] args) {
        String fajlNev = "fuvar.csv";
        try {
            beolvas(fajlNev);
            for (Fuvar i: fuvarok) {
                System.out.println(i);
            }

            // 1. feladat
            System.out.printf("\nAz állományban %d fuvar került feljegyzésre",
                    fuvarok.stream().count());

            //2. feladat
            //fuvarok.stream().filter(fuvarok -> fuvarok.getTaxiAzonosito() == 6185).mapToDouble(Fuvar::getVetelDij)
            System.out.printf("\n6185 azonosítójú taxisnak %s volt a bevétele ez %d fuvarból állt",fuvarok.stream().filter(fuvarok -> fuvarok.getTaxiAzonosito() == 6185).mapToDouble(Fuvar::getBevetel).sum() ,
                    fuvarok.stream().filter(fuvarok -> fuvarok.getTaxiAzonosito() == 6185).count());

            //3. feladat
            System.out.printf("\nÖsszesen %s mérföldet tettek meg a taxisok",fuvarok.stream().mapToDouble(fuvarok -> fuvarok.getMeglettTavolsag()).sum());

            //4. feladat
            System.out.printf("\nA leghosszabb fuvar adatai: %s",fuvarok.stream().max(Comparator.comparingInt(Fuvar::getUtazasIdotartama)));

            //5. feladat
            System.out.printf("\nA legbőkezűbb borravalójú fuvar adatai: %s",fuvarok.stream().max(Comparator.comparingDouble(Fuvar::getArany)));

            //6. feladat
            System.out.printf("\nA 4261 azonosítójú taxis összesen: %s km tett meg.",fuvarok.stream().filter(fuvarok -> fuvarok.getTaxiAzonosito() == 4261).mapToDouble(Fuvar::getMeglettTavolsag).sum()*1.6);


            //7. feladat
            //System.out.println("Hibás adatok: \n");
            //System.out.println("\n Száma: \nösszes időtartalma: \nTeljes bevétel");

            //8. feladat
            System.out.printf("\nSzerepel-e 1452-es fuvar: %s", fuvarok.stream().anyMatch(fuvarok -> fuvarok.getTaxiAzonosito() == 1452));

            //9. feladat
            System.out.println("\nA legrövidebb fuvar: ");
            fuvarok.stream().filter(fuvar -> fuvar.getUtazasIdotartama()>0).sorted((a,b)->a.getUtazasIdotartama()-b.getUtazasIdotartama()).collect(Collectors.toList()).stream().limit(3).forEach(System.out::println);

            //10. feladat
            System.out.printf("\nDecember 24-én %s fuvar volt.", fuvarok.stream().filter(fuvar -> fuvar.getIndulasIdopont().contains("2016-12-24")).count());

            //11. feladat
            System.out.println("\nDecember 31-én a borravalók aránya: ");
            List<Double> borravalok=fuvarok.stream().filter(fuvar -> fuvar.getIndulasIdopont().contains("2016-12-31")).map(Fuvar::getArany).collect(Collectors.toList());
            borravalok.forEach(System.out::println);


        }catch (IOException e){
            System.out.printf("\nHiba történt a(z) %s fájl beolvasása során", fajlNev);
        }
    }
    private static void beolvas(String fajlNev) throws IOException{
        fuvarok = new ArrayList<>();

        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);
        String fejlec  = br.readLine();


        String sor = br.readLine();
        while (sor != null && !sor.isEmpty()){
        String[] adatok = sor.replace(",", ".").split(";");
            Fuvar i = new Fuvar(Integer.parseInt(adatok[0]),
                    adatok[1],
                    Integer.parseInt(adatok[2]),
                    Double.parseDouble(adatok[3]),
                    Double.parseDouble(adatok[4]),
                    Double.parseDouble(adatok[5]),
                    adatok[6]);

                    fuvarok.add(i);
                    sor = br.readLine();
        }

        br.close();
        fr.close();
    }
}