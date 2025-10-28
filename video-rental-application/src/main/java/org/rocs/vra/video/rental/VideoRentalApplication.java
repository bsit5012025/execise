package org.rocs.vra.video.rental;

import org.rocs.vra.video.rental.app.facade.item.ItemFacade;
import org.rocs.vra.video.rental.app.facade.item.impl.ItemFacadeImpl;
import org.rocs.vra.video.rental.data.connection.ConnectionHelper;
import org.rocs.vra.video.rental.data.dao.item.ItemDao;
import org.rocs.vra.video.rental.data.dao.item.impl.ItemDaoImpl;
import org.rocs.vra.video.rental.model.item.Item;

import java.sql.Connection;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * */
public class VideoRentalApplication {

    public static void main(String[] args) {

    try {
        ItemFacade itemFacade = new ItemFacadeImpl();
        Item item = itemFacade.getItemById(new String());

        System.out.println("Find By ID");
        System.out.println(item.toString());
    } catch (Exception e) {
        e.printStackTrace();
    }

//        System.out.println("Find All");
//        List<Item> items = itemDao.findAll();
//        items.stream().forEach(i -> System.out.println(i));
//
//        System.out.println("Save Item");
//        Item itemToSave = new Item("3", "Train to Busan", "Suspense", 5);
//        boolean result = itemDao.saveItem(itemToSave);
//        String output = result ? "Item Saved!" : "Item not saved!";
//        System.out.println(output);

    }
}
