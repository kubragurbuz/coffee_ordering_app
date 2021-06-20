package kubra.gurbuz.coffee.ordering.app;

import kubra.gurbuz.coffee.ordering.app.entity.CoffeeEntity;
import kubra.gurbuz.coffee.ordering.app.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
@Profile("!test")
public class CommandLineAppStartupRunner implements CommandLineRunner {

  @Autowired
  private CoffeeService service;

  @Override
  public void run(String... args) throws Exception {

    List<CoffeeEntity> entities = service.writeCoffeeListConsole();
    System.out.println("Lütfen içmek istediğiniz kahvenin numarasını giriniz");

    Scanner scanner = new Scanner(System.in);

    while (scanner.hasNextInt()) {
      Integer coffeNumber = scanner.nextInt();
      // Konsoldan girilen kahve numarası geçerli mi diye kontrol ediyor
      List<CoffeeEntity> coffeeEntities = entities.stream().filter(coffeeEntity -> coffeeEntity.getId().equals(coffeNumber)).collect(Collectors.toList());

      if (coffeeEntities.size() > 0) {
        //ikinci commit de istenilen mesajı buraya yazacağım servise de vereceğim
        scanner.close();
        System.out.println("Teşekkürler kahveniz hazırlanıyor.");
        coffeeEntities.get(0).getMessage();
        System.exit(0);
      } else {  //ard arda hatalı giriş yapan veri varsa hata mesajı verip konsoldan tekrar giriş yapmasını istiyoruz
        errorMessage();
      }
    }
  }

  private void errorMessage() {
    System.out.println("Hatalı giriş yaptınız! Lütfen içmek istediğiniz kahvenin numarasını giriniz ");
  }

}
