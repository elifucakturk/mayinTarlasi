import java.util.Random;
import java.util.Scanner;

public class mayinTarlasi {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz !");
        System.out.println("===========================");
       System.out.print("Satır sayısını giriniz: ");
        int satirSayisi = scanner.nextInt();
        System.out.print("Sütun sayısını giriniz: ");
        int sutunSayisi = scanner.nextInt();
        char[][] mayinTarlasi = new char[satirSayisi][sutunSayisi];
        int[][] mayinKonumlari = new int[satirSayisi][sutunSayisi];
        mayinlariYerlestir(mayinKonumlari);
        boolean oyunDevamEdiyor = true;
          while (oyunDevamEdiyor) {
            mayinTarlasiGoster(mayinTarlasi);
            System.out.print("Satır Giriniz: ");
            int satir = scanner.nextInt();
            System.out.print("Sütun Giriniz: ");
            int sutun = scanner.nextInt();
          if (!gecerliNokta(satir, sutun, satirSayisi, sutunSayisi)) {
                System.out.println("Geçersiz nokta. Lütfen tekrar deneyin.");
                continue;  }
          if (mayinKonumlari[satir][sutun] == -1) {
                oyunDevamEdiyor = false;
                System.out.println("Game Over!!"); } else {
                int mayinSayisi = mayinlariKontrolEt(mayinKonumlari, satir, sutun);
                mayinTarlasinaYaz(mayinTarlasi, satir, sutun, mayinSayisi);
          if (kazanmaKontrolu(mayinTarlasi, mayinKonumlari)) {
                    oyunDevamEdiyor = false;
                    System.out.println("Oyunu Kazandınız !");
                    mayinTarlasiGoster(mayinTarlasi);  }  } }
          scanner.close();   }
          private static void mayinlariYerlestir(int[][] mayinKonumlari) {
         Random random = new Random();
         int mayinSayisi = mayinKonumlari.length * mayinKonumlari[0].length / 4;

        for (int i = 0; i < mayinSayisi; i++) {
            int satir = random.nextInt(mayinKonumlari.length);
            int sutun = random.nextInt(mayinKonumlari[0].length);

            
            while (mayinKonumlari[satir][sutun] == -1) {
                satir = random.nextInt(mayinKonumlari.length);
                sutun = random.nextInt(mayinKonumlari[0].length);
            }

            mayinKonumlari[satir][sutun] = -1;
        }
    }

    private static void mayinTarlasiGoster(char[][] mayinTarla) {
        System.out.println("===========================");
        for (char[] satir : mayinTarla) {
            for (char hucre : satir) {
                System.out.print(hucre + " ");
            }
            System.out.println();
        }
        System.out.println("===========================");
    }
    private static boolean gecerliNokta(int satir, int sutun, int satirSayisi, int sutunSayisi) {
        return satir >= 0 && satir < satirSayisi && sutun >= 0 && sutun < sutunSayisi;
    }
    private static int mayinlariKontrolEt(int[][] mayinKonumlari, int satir, int sutun) {
        int mayinSayisi = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int yeniSatir = satir + i;
                int yeniSutun = sutun + j;

                if (gecerliNokta(yeniSatir, yeniSutun, mayinKonumlari.length, mayinKonumlari[0].length)
                        && mayinKonumlari[yeniSatir][yeniSutun] == -1) {
                    mayinSayisi++;   }  }  }
        return mayinSayisi;   }
    private static void mayinTarlasinaYaz(char[][] mayinTarla, int satir, int sutun, int deger) {
        mayinTarla[satir][sutun] = (char) (deger + '0');
    }
   private static boolean kazanmaKontrolu(char[][] mayinTarla, int[][] mayinKonumlari) {
        for (int i = 0; i < mayinTarla.length; i++) {
            for (int j = 0; j < mayinTarla[0].length; j++) {
                if (mayinTarla[i][j] == '\u0000' && mayinKonumlari[i][j] != -1) {
                    return false;  } } }
        return true;  } }
