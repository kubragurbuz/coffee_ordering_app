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
  private String price;

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

  public String getPrice() {
    return price;
  }

  public void setPrice(String price) {
    this.price = price;
  }

  @JsonManagedReference
  public List<CoffeeMaterialRelEntity> getCoffeeMaterialRelEntities() {
    return coffeeMaterialRelEntities;
  }

  public void setCoffeeMaterialRelEntities(List<CoffeeMaterialRelEntity> coffeeMaterialRelEntities) {
    this.coffeeMaterialRelEntities = coffeeMaterialRelEntities;
  }

}
