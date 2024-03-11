package mhkif.yc.usersservice.services;

import org.springframework.data.domain.Page;

import java.util.List;

public interface Service<Entity, pk, Req, Res> {

    Res getById(pk id);
    Page<Res> getAllPages(int page, int size);
    List<Res> getAll();
    Res create(Req request);

}
