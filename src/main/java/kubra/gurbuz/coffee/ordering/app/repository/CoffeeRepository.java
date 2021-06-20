package kubra.gurbuz.coffee.ordering.app.repository;

import kubra.gurbuz.coffee.ordering.app.entity.CoffeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoffeeRepository extends JpaRepository<CoffeeEntity, Integer> {
}
