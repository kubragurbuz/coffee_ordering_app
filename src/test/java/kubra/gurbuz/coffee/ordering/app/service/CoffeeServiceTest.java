package kubra.gurbuz.coffee.ordering.app.service;

import kubra.gurbuz.coffee.ordering.app.entity.CoffeeEntity;
import kubra.gurbuz.coffee.ordering.app.repository.CoffeeRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class CoffeeServiceTest {

  @Autowired
  private CoffeeRepository repository;

  @Autowired
  private CoffeeService service;

  @Test
  public void getEspressoCoffeeTest() {
    CoffeeEntity coffeeEntities = repository.findById(1).get() ;
    Assert.assertEquals("Espresso", coffeeEntities.getName());
  }

  @Test
  public void getAllCoffee() {
    Assert.assertEquals(7, service.getAllCoffee().size());
  }

}
