package com.diegodelacruz.springreactor.service;

import com.diegodelacruz.springreactor.model.Dish;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IDishService {

    Mono<Dish> save(Dish dish);

    Mono<Dish> update(Dish dish, String id);

    Flux<Dish> findAll();

    Mono<Dish> findById(String id);

    Mono<Boolean> delete(String id);
}
