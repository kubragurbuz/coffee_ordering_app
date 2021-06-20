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

}
