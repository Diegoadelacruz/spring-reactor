package com.diegodelacruz.springreactor.service.impl;

import com.diegodelacruz.springreactor.model.Dish;
import com.diegodelacruz.springreactor.repository.IDishRepo;
import com.diegodelacruz.springreactor.service.IDishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements IDishService {

    private final IDishRepo repo;

    @Override
    public Mono<Dish> save(Dish dish) {
        return repo.save(dish);
    }

    @Override
    public Mono<Dish> update(Dish dish, String id) {
        return repo.findById(id).flatMap(e -> repo.save(dish));
    }

    @Override
    public Flux<Dish> findAll() {
        return repo.findAll();
    }

    @Override
    public Mono<Dish> findById(String id) {
        return repo.findById(id);
    }

    @Override
    public Mono<Boolean> delete(String id) {
        return repo.findById(id)
                .hasElement()
                .flatMap(result -> {
                    if (result) {
                        return repo.deleteById(id).thenReturn(true);
                    } else {
                        return Mono.just(false);
                    }
                });
    }

}
