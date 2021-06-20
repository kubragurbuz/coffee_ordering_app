package kubra.gurbuz.coffee.ordering.app.service;

import kubra.gurbuz.coffee.ordering.app.entity.CoffeeEntity;
import kubra.gurbuz.coffee.ordering.app.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CoffeeService {

  @Autowired
  public CoffeeRepository coffeeRepository;

  public List<CoffeeEntity> getAllCoffee() {
    return coffeeRepository.findAll();
  }

  public List<CoffeeEntity> writeCoffeeListConsole() {
    // DB de kaydedilmiş tüm aktif kullanılan kahve listesini döner
    List<CoffeeEntity> entities = this.getAllCoffee();
    // Konsola kahve listesindeki özellikleri istenilen formatta yazar
    entities.forEach(entity ->
        System.out.println(entity.getId() + ". " + entity.getName() + "(" + entity.getPrice() + entity.getCur().getSymbol() + ")"));
    return entities;
  }

}
