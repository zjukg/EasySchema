package com.zj.easychema;


import com.zj.easychema.pojo.Type;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@SpringBootTest
class EasychemaApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Test
    void contextLoads() {
        Query query = new Query(Criteria.where("nameZh").regex("3D模型"));
        List<Type> all = mongoTemplate.find(query,Type.class);
        System.out.println(all);
    }

}
