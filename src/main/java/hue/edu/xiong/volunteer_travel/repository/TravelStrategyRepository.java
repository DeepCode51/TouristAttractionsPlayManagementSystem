package hue.edu.xiong.volunteer_travel.repository;

import hue.edu.xiong.volunteer_travel.model.TravelStrategy;
import hue.edu.xiong.volunteer_travel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface TravelStrategyRepository extends JpaRepository<TravelStrategy, String>, JpaSpecificationExecutor<TravelStrategy> {



}
