package com.timetracker.timetracker.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.timetracker.timetracker.database.Category;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

}
