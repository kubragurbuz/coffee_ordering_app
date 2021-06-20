package kubra.gurbuz.coffee.ordering.app.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "coffee")
@Where(clause = "is_actv = 1")
public class CoffeeEntity {

  @Id
  private Integer id;

  private String name;
  private Integer price;

  @ManyToOne
  @JoinColumn(name = "cur_id")
  private CurEntity cur;

  @Column(name = "is_actv")
  private Integer isActv;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "coffee", fetch = FetchType.EAGER)
  private List<CoffeeMaterialRelEntity> coffeeMaterialRelEntities;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CurEntity getCur() {
    return cur;
  }

  public void setCur(CurEntity cur) {
    this.cur = cur;
  }

  public Integer getIsActv() {
    return isActv;
  }

  public void setIsActv(Integer isActv) {
    this.isActv = isActv;
  }

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  @JsonManagedReference
  public List<CoffeeMaterialRelEntity> getCoffeeMaterialRelEntities() {
    return coffeeMaterialRelEntities;
  }

  public void setCoffeeMaterialRelEntities(List<CoffeeMaterialRelEntity> coffeeMaterialRelEntities) {
    this.coffeeMaterialRelEntities = coffeeMaterialRelEntities;
  }

  public void getMessage() {
    String coffeeMessage;
    List<String> selectedCoffee = new ArrayList<>();

    //seçilen kahvenin içerisinde kullanılan malzemeleri liste içerisine ekliyor
    getCoffeeMaterialRelEntities().forEach(pr -> selectedCoffee.add( pr.getMeasure() + " doz " + pr.getMaterial().getName()));

    // Kahve birden fazla içerikten oluşuyorsa içerikleri birbirine bağlıyoruz
    if(getCoffeeMaterialRelEntities().size() > 1) {
      coffeeMessage = String.join(", ", selectedCoffee.subList(0, selectedCoffee.size() - 1))
          + " ve " + selectedCoffee.get(selectedCoffee.size() - 1);

      setMessage(coffeeMessage);
    } else if (getCoffeeMaterialRelEntities().size() == 1) {  //kahve tek içerikten oluşuyorsa
      coffeeMessage = selectedCoffee.get(0);
      setMessage(coffeeMessage);
    } else {  // kahve içeriği bulunamadıysa
      System.out.println("Kahve içeriği oluşturulamadı!");
    }
  }

  private void setMessage(String coffeeMessage) {
    System.out.println(getName() + " seçtiniz. Bu içeceğimiz " + coffeeMessage  + " içermektedir. Afiyet Olsun.");
  }
}
