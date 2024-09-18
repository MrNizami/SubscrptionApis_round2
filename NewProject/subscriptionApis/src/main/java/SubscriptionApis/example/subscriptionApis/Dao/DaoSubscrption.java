package SubscriptionApis.example.subscriptionApis.Dao;

import SubscriptionApis.example.subscriptionApis.Model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DaoSubscrption extends JpaRepository<Subscription,Long> {

}
