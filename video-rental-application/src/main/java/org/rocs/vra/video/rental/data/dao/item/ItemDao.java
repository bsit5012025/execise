package org.rocs.vra.video.rental.data.dao.item;

import org.rocs.vra.video.rental.model.item.Item;

import java.util.List;

public interface ItemDao {

    //READ
    Item findItemById(String id);
    List<Item> findAll();

    //CREATE
    boolean saveItem(Item item);

    //UPDATE
    boolean updateItem(Item item);

    //DELETE
    int deleteItem(String id);

}
