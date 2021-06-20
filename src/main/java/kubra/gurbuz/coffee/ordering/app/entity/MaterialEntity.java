package kubra.gurbuz.coffee.ordering.app.entity;

import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "material")
@Where(clause = "is_actv = 1")
public class MaterialEntity {

  @Id
  private Integer id;
  private String name;
  @Column(name = "is_actv")
  private Integer isActv;

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

  public Integer getIsActv() {
    return isActv;
  }

  public void setIsActv(Integer isActv) {
    this.isActv = isActv;
  }
}
