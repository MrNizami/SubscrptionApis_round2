package SubscriptionApis.example.subscriptionApis.Conroller;

import SubscriptionApis.example.subscriptionApis.Business.SubscriptionService;

import SubscriptionApis.example.subscriptionApis.Model.Subscription;
import SubscriptionApis.example.subscriptionApis.dto.SubcrptionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/subscription")
public class SubscriptionController {

    @Autowired
    SubscriptionService businessSubscription;


    @GetMapping("/get-all-active-by-type")
        public List<SubcrptionDto> getAllActiveSubcriptionByType(@RequestParam(value = "type") String type) throws Exception {
             return businessSubscription.getAllSubscriptionsByType(type);
    }





}
