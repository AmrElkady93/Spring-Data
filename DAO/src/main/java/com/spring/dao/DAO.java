package com.spring.dao;

import java.util.List;

public interface DAO<Entity> {

    public int count();
    public List<Entity> getAll();
    public <ID> Entity getRecordByID(ID id);
    public Entity insert(Entity entity);
    public Entity update(Entity entity);
    public <ID> void deleteByID(ID id);
    public <Obj> void deleteByObject(Obj entity);

}
