package SubscriptionApis.example.subscriptionApis.Business;

import SubscriptionApis.example.subscriptionApis.Dao.DaoSubscrption;
import SubscriptionApis.example.subscriptionApis.Model.Subscription;
import SubscriptionApis.example.subscriptionApis.dto.SubcrptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubscriptionService {

    @Autowired
    DaoSubscrption daoSubscrption;


    public  List<SubcrptionDto> getAllSubscriptionsByType(String type) throws Exception {

        try{
            List<Subscription> subscriptions =  daoSubscrption.findAll();
            subscriptions = getAllSubcriptionByType(type,subscriptions);
            subscriptions =  getAllActiveSubcription(subscriptions);
            List<SubcrptionDto> result = getSubcriptionDtofromEntity(subscriptions);
            return result;
        }
        catch(Exception e){
            throw new Exception("Error in getting the data ") ;
        }

    }

    private List<SubcrptionDto> getSubcriptionDtofromEntity(List<Subscription> models){
        List<SubcrptionDto> result = new ArrayList<>();
        for(Subscription subscription: models ){
            SubcrptionDto dto = new SubcrptionDto();
            dto.setId(subscription.getId());
            dto.setSubscriptionType(subscription.getSubscriptionType());
            dto.setIsActive(subscription.getIsActive());
            dto.setEndDate(subscription.getEndDate());
            dto.setStartingDate(subscription.getStartingDate());
            result.add(dto);
        }
        return result;
    }


    private List<Subscription> getAllActiveSubcription(List<Subscription> models){
        List<Subscription> result = models.stream().filter(i->i.getIsActive()==true).collect(Collectors.toList());
        return result;
    }

    private List<Subscription> getAllSubcriptionByType(String type,List<Subscription>models){
        List<Subscription> list = models.stream().filter(i->i.getSubscriptionType().equals(type))
                .collect(Collectors.toList());
        return list;
    }


}
