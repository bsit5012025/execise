package org.rocs.vra.video.rental.data.dao.item.impl;

import org.rocs.vra.video.rental.data.connection.ConnectionHelper;
import org.rocs.vra.video.rental.data.dao.item.ItemDao;
import org.rocs.vra.video.rental.model.item.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    @Override
    public Item findItemById(String id) {
        Item item = null;

        try (Connection con = ConnectionHelper.getConnection()){

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM ITEM WHERE ID = ?");
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                item = new Item();
                item.setId(rs.getString("id"));
                item.setTitle(rs.getString("title"));
                item.setGenre(rs.getString("genre"));
                item.setCopies(rs.getInt("copies"));
            }

        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }

        return item;
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemList = new ArrayList<>();

        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("SELECT * FROM ITEM");
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Item item = new Item();
                item.setId(rs.getString("id"));
                item.setTitle(rs.getString("title"));
                item.setGenre(rs.getString("genre"));
                item.setCopies(rs.getInt("copies"));
                itemList.add(item);
            }

        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
        }
        return itemList;
    }

    @Override
    public boolean saveItem(Item item) {
        try (Connection con = ConnectionHelper.getConnection()) {
            PreparedStatement stmt = con.prepareStatement("INSERT INTO ITEM (ID, TITLE, GENRE, COPIES) VALUES (?, ?, ?, ?)");
            stmt.setString(1, item.getId());
            stmt.setString(2, item.getTitle());
            stmt.setString(3, item.getGenre());
            stmt.setInt(4, item.getCopies());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("An SQL Exception occurred." + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateItem(Item item) {
        try(Connection con = ConnectionHelper.getConnection())
        {
            PreparedStatement stmt = con.prepareStatement("UPDATE ITEM SET TITLE=?, GENRE=?, COPIES=? WHERE ID=?");
            stmt.setString(1, "some1");
            stmt.setString(2, "some3");
            stmt.setString(3, "some2");
        }
        catch (SQLException e)
        {
            System.out.println("An Exception occured "+ e.getMessage);
            return false;
        }

    }

    @Override
    public int deleteItem(String id) {
        return 0;
    }
}
