package com.coalvalue.repository.specific;


import com.coalvalue.domain.entity.InstanceTransport;
import com.coalvalue.dto.InstanceTransportDto;
import com.util.StringUtil;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhao yuan on 26/07/2015.
 */
public class InstanceTransportSpec {

    private InstanceTransportDto instanceTransportDto;

    public InstanceTransportSpec(InstanceTransportDto bankCardDto) {
        this.instanceTransportDto = bankCardDto;
    }


    public Specification<InstanceTransport> querySynthesizedSpec() {


        Specification<InstanceTransport> specification = (root, query, cb) -> {


            List<Predicate> predicateList = new ArrayList<Predicate>();



            if (!StringUtil.isEmpty(instanceTransportDto.getStatus())) {
                //  Predicate predicate = cb.like(root.<String>get("plateNumber"), "%"+bankCardDto.getSearchText().trim()+"%");
                //  predicateList.add(cb.or(predicate));
                Predicate predicate_pro = cb.equal(root.<String>get("status"), instanceTransportDto.getStatus());
                predicateList.add(cb.or(predicate_pro));


            }
            if (instanceTransportDto.getStorageNo()!= null) {
                //  Predicate predicate = cb.like(root.<String>get("plateNumber"), "%"+bankCardDto.getSearchText().trim()+"%");
                //  predicateList.add(cb.or(predicate));
                Predicate predicate_pro = cb.equal(root.<String>get("storageNo"), instanceTransportDto.getStorageNo());
                predicateList.add(cb.or(predicate_pro));


            }



            if (!StringUtil.isEmpty(instanceTransportDto.getSearchText())) {
                List<Predicate> predicateList_OR = new ArrayList<Predicate>();
                //  Predicate predicate = cb.like(root.<String>get("plateNumber"), "%"+bankCardDto.getSearchText().trim()+"%");
                //  predicateList.add(cb.or(predicate));
      /*          Predicate predicate_pro = cb.like(root.<String>get("productName"), "%"+ bankCardDto.getSearchText().trim()+"%");
                Predicate predicate_idNumber = cb.like(root.<String>get("idNumber"), "%"+ bankCardDto.getSearchText().trim()+"%");*/
                Predicate predicate_plateNumber = cb.like(root.<String>get("plateNumber"), "%"+ instanceTransportDto.getSearchText().trim()+"%");
               // predicateList.add(cb.or(predicate_idNumber));
                predicateList_OR.add(cb.or(predicate_plateNumber));
             //   predicateList.add(cb.or(predicate_pro));

                predicateList.add(cb.or(predicateList_OR.toArray(new Predicate[0])));
            }


/*            if(bankCardDto.getAccountName() != null) {
                Predicate  predicate = cb.equal(root.<Integer>get("accountName"), bankCardDto.getAccountName());
                predicateList.add(predicate);
            }
            if(bankCardDto.getAccountType() != null) {
                Predicate  predicate = cb.equal(root.<Integer>get("accountType"), bankCardDto.getAccountType());
                predicateList.add(predicate);
            }*/
            return cb.and(predicateList.toArray(new Predicate[0]));
        };
        return specification;
    }


}
