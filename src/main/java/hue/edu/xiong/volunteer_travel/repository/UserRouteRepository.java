package hue.edu.xiong.volunteer_travel.repository;

import hue.edu.xiong.volunteer_travel.model.*;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

@Repository
public interface UserRouteRepository extends JpaRepository<UserRoute, String>, JpaSpecificationExecutor<UserRoute> {

    List<UserRoute> findUserRouteByUser(User user);

    UserRoute findUserRouteByTravelRouteAndUser(TravelRoute travelRoute, User user);
}
