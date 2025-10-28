package org.rocs.vra.video.rental.data.dao.item.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.rocs.vra.video.rental.data.connection.ConnectionHelper;
import org.rocs.vra.video.rental.data.dao.item.ItemDao;
import org.rocs.vra.video.rental.model.item.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ItemDaoImplTest {

    @Mock
    private ItemDao itemDao;

    @Mock
    private Connection connection;

    @Mock
    private PreparedStatement preparedStatement;

    @Mock
    private ResultSet resultSet;

    private static MockedStatic<ConnectionHelper> connectionHelper;

    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.openMocks(this);
        connection = mock(Connection.class);
        preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        connectionHelper = Mockito.mockStatic(ConnectionHelper.class);
        connectionHelper.when(ConnectionHelper::getConnection).thenReturn(connection);
    }

    @Test
    void findItemByIdShouldReturnAnItem() throws SQLException {

        when(resultSet.getString("id")).thenReturn("1");
        when(resultSet.getString("title")).thenReturn("Test Title");
        when(resultSet.getString("genre")).thenReturn("Test Genre");
        when(resultSet.getInt("copies")).thenReturn(1);
        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(resultSet.next()).thenReturn(Boolean.TRUE, Boolean.FALSE);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);

        itemDao = new ItemDaoImpl();
        Item item = itemDao.findItemById("2");

        assertEquals("1", item.getId());
        assertEquals(1, item.getCopies());
        assertNull(item);
    }

    @Test
    public void testSaveItem() throws SQLException {
        Item item = new Item();
        item.setId("2");
        item.setTitle("Test Title");
        item.setGenre("Test Genre");
        item.setCopies(2);

        when(connection.prepareStatement(any(String.class))).thenReturn(preparedStatement);
        when(preparedStatement.executeUpdate()).thenReturn(1);

        ItemDao itemDao = new ItemDaoImpl();
        boolean result = itemDao.saveItem(item);

        verify(connection, times(1)).prepareStatement(anyString());
        verify(preparedStatement, times(3)).setString(anyInt(), anyString());
        verify(preparedStatement, times(1)).setInt(anyInt(), anyInt());
        verify(preparedStatement, times(1)).executeUpdate();
        assertTrue(result);
    }


}