package org.rocs.vra.video.rental.app.facade.item.impl;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.rocs.vra.video.rental.app.facade.item.ItemFacade;

import static org.junit.jupiter.api.Assertions.*;

class ItemFacadeImplTest {

//    @InjectMocks
//    private ItemFacade itemFacade;

    @Test
    void getItemByIdWithBlankIdShoudThrowException() {
        ItemFacade itemFacade = new ItemFacadeImpl();
        Exception exception = assertThrows(Exception.class, () -> itemFacade.getItemById(""));
        assertEquals("Id is not present", exception.getMessage());
    }

    @Test
    void onePlusOneShouldEqualsTwo() {
        ItemFacade itemFacade = new ItemFacadeImpl();
        int sum = itemFacade.getSum(1, 1);
        assertEquals(2, sum);
    }
}