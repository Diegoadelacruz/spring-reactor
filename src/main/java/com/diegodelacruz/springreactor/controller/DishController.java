package com.diegodelacruz.springreactor.controller;

import com.diegodelacruz.springreactor.model.Dish;
import com.diegodelacruz.springreactor.service.IDishService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/dishes")
@RequiredArgsConstructor
public class DishController {

    private final IDishService service;

    @GetMapping
    public Flux<Dish> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Dish> findById(@PathVariable("id") String id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<Dish> save(@RequestBody Dish dish) {
        return service.save(dish);
    }

    @PutMapping("/{id}")
    public Mono<Dish> update(@RequestBody Dish dish, @PathVariable("id") String id) {
        return Mono.just(dish)
                .map(e -> {
                    e.setId(id);
                    return e;
                })
                .flatMap(e -> service.update(dish, id));
    }

    @DeleteMapping("/{id}")
    public Mono<Boolean> delete(@PathVariable("id") String id) {
        return service.delete(id);
    }

}
