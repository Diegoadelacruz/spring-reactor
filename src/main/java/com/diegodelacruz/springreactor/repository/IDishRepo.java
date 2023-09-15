package com.diegodelacruz.springreactor.repository;

import com.diegodelacruz.springreactor.model.Dish;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IDishRepo extends ReactiveMongoRepository<Dish, String> {
}
