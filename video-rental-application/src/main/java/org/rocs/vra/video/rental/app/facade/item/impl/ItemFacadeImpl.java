package org.rocs.vra.video.rental.app.facade.item.impl;

import org.apache.commons.lang3.StringUtils;
import org.rocs.vra.video.rental.app.facade.item.ItemFacade;
import org.rocs.vra.video.rental.data.dao.item.ItemDao;
import org.rocs.vra.video.rental.data.dao.item.impl.ItemDaoImpl;
import org.rocs.vra.video.rental.model.item.Item;

public class ItemFacadeImpl implements ItemFacade{

    private ItemDao itemDao;

    public ItemFacadeImpl() {
        this.itemDao = new ItemDaoImpl();
    }

    @Override
    public Item getItemById(String id) throws Exception {
        if(StringUtils.isEmpty(id) || StringUtils.isBlank(id)) {
            throw new Exception("Id is not present");
        }
        return itemDao.findItemById(id);
    }

    @Override
    public int getSum(int x, int y) {
        return x + y;
    }
}
