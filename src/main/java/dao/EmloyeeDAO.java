package dao;

import entity.Emloyee;

import java.util.List;

public interface EmloyeeDAO {

    void add(Emloyee emloyee);

    List<Emloyee> getAll();

    Emloyee getById(Long id);

    void update(Emloyee emloyee);

    void remove(Emloyee emloyee);

}
