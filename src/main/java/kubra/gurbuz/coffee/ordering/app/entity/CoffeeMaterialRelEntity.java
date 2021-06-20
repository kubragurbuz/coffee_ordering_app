package kubra.gurbuz.coffee.ordering.app.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Table
@Entity(name = "coffee_material_rel")
@Where(clause = "is_actv = 1")
public class CoffeeMaterialRelEntity {

  @Id
  private Integer id;

/*  @Column(name = "coffee_id")
  private Integer coffeeId;

  @Column(name = "material_id")
  private Integer materialId;*/

  @ManyToOne
  @JoinColumn(name = "coffee_id" )
  private CoffeeEntity coffee;

  @ManyToOne
  @JoinColumn(name = "material_id")
  private MaterialEntity material;

  private Integer measure;

  @Column(name = "is_actv")
  private Integer isActv;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @JsonBackReference
  public CoffeeEntity getCoffee() {
    return coffee;
  }

  public void setCoffee(CoffeeEntity coffee) {
    this.coffee = coffee;
  }

  public MaterialEntity getMaterial() {
    return material;
  }

  public void setMaterial(MaterialEntity material) {
    this.material = material;
  }

  public Integer getMeasure() {
    return measure;
  }

  public void setMeasure(Integer measure) {
    this.measure = measure;
  }

  public Integer getIsActv() {
    return isActv;
  }

  public void setIsActv(Integer isActv) {
    this.isActv = isActv;
  }


}
