package kubra.gurbuz.coffee.ordering.app;

import kubra.gurbuz.coffee.ordering.app.entity.CoffeeEntity;
import kubra.gurbuz.coffee.ordering.app.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

  @Autowired
  private CoffeeService service;

  @Override
  public void run(String... args) throws Exception {

    // DB de kaydedilmiş tüm aktif kullanılan kahve listesini döner
    List<CoffeeEntity> entities = service.getAllCoffee();
    // Konsola kahve listesindeki özellikleri istenilen formatta yazar
    entities.forEach(entity ->
        System.out.println(entity.getId() + ". " + entity.getName() + "(" + entity.getPrice() + entity.getCur().getSymbol() + ")"));

    System.out.println("Lütfen içmek istediğiniz kahvenin numarasını giriniz");

    Scanner scanner = new Scanner(System.in);

    // integer dışında bir giriş oldu ise
    while (!scanner.hasNextInt()) {
      scanner.next();
      errorMessage();
    }

    while (scanner.hasNextInt()) {
      Integer coffeNumber = scanner.nextInt();
      // Konsoldan girilen kahve numarası geçerli mi diye kontrol ediyor
      List<CoffeeEntity> coffeeEntities = entities.stream().filter(coffeeEntity -> coffeeEntity.getId().equals(coffeNumber)).collect(Collectors.toList());
      if (coffeeEntities.size() > 0) {
        break;
      } else {  //ard arda hatalı giriş yapan veri varsa hata mesajı verip konsoldan tekrar giriş yapmasını istiyoruz
        errorMessage();
      }
    }
  }

  private void errorMessage() {
    System.out.println("Hatalı giriş yaptınız! Lütfen içmek istediğiniz kahvenin numarasını giriniz ");
  }

}
