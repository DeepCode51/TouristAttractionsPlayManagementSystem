package hue.edu.xiong.volunteer_travel.repository;

import hue.edu.xiong.volunteer_travel.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserAttractionsRepository extends JpaRepository<UserAttractions, String>, JpaSpecificationExecutor<UserAttractions> {

    List<UserAttractions> findUserAttractionsByUser(User user);

    UserAttractions findUserAttractionsByAttractionsAndUser(Attractions attractions, User user);
}
