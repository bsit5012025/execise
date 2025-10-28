package org.rocs.vra.video.rental.app.facade.item;

import org.rocs.vra.video.rental.model.item.Item;

public interface ItemFacade {

    Item getItemById(String id) throws Exception;

    int getSum(int x, int y);
}
