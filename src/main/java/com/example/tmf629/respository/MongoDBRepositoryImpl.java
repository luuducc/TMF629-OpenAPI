package com.example.tmf629.respository;

import com.example.tmf629.model.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MongoDBRepositoryImpl implements UserRepository {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public void save(User user) {
        System.out.println(user.getClass().getName());
        mongoTemplate.insert(user);
    }

    @Override
    public User findById(String id) {
        return mongoTemplate.findById(id, User.class);
    }

    @Override
    public List<User> findAll() {
        return mongoTemplate.findAll(User.class);
    }

    @Override
    public User updateById(String id, User user) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();

        if (user.getName() != null) update.set("name", user.getName());
        if (user.getEmail() != null) update.set("email", user.getEmail());

        UpdateResult result = mongoTemplate.updateFirst(query, update, User.class);
        if (result.getMatchedCount() == 0) {
            System.out.println("No document updated");
        } else if (result.getModifiedCount() == 0) {
            System.out.println("Document is not modified");
        } else {
            System.out.println("Document updated");
        }

        return null;
    }

    @Override
    public void deleteById(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        mongoTemplate.remove(query, User.class);
    }

    @Override
    public boolean existsByEmail(String email) {
        Query query = new Query(Criteria.where("email").is(email));
        return mongoTemplate.exists(query, User.class);
    }
}
