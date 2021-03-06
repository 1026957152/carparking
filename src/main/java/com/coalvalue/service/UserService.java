package com.coalvalue.service;

//import com.coalvalue.domain.User;
import com.coalvalue.domain.entity.PlateRecognition;
import com.coalvalue.domain.entity.User;
import com.coalvalue.notification.NotificationData;
//import com.coalvalue.web.valid.UserCreateForm;
import com.coalvalue.web.valid.UserCreateForm;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * Created by silence yuan on 2015/7/25.
 */
public interface UserService extends BaseService {



    void create(NotificationData data);

    void analyis(PlateRecognition plateRecognition);


    Page<Map> querySynthesized(Object o, Pageable pageable);

    void addPlate(PlateRecognition plateRecognition);

    void addPlate_IDIdentification(Integer idIentificationId);

    void add_delivery_order(NotificationData deliveryOrderId);

    void analyisQrcode(String text);

    User create(UserCreateForm userCreateForm);

}
