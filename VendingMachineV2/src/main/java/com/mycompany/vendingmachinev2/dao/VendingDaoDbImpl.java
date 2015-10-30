


package com.mycompany.vendingmachinev2.dao;

import com.mycompany.vendingmachinev2.model.Item;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


public class VendingDaoDbImpl implements VendingDao {

    private static final String SQL_INSERT_ITEM = 
            
            "insert ignore into items (name, cost, code, count) values (?, ?, ?, ?)";
    
    private static final String SQL_DELETE_ITEM = 
            "delete from items where code = ?";
    
    private static final String SQL_SELECT_ITEM = 
            "select * from items where code = ?";
    
    private static final String SQL_SELECT_ALL_ITEMS = 
            "select * from items";
    
    private static final String SQL_UPDATE_ITEM = 
            "update items set name = ?, cost = ?, count = ? where code = ?";
    
    private static final String SQL_LOWER_COUNT = 
            "Update items Set count = IF(count > 0, count -1, 0) Where code = ?";
    
    private static final String SQL_ITEM_COUNT = 
            "select count from items where code = ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addItem(Item item) {
        jdbcTemplate.update(SQL_INSERT_ITEM, 
                item.getName(),
                item.getCost(),
                item.getCode(),
                item.getCount());
    }

    @Override
    public void removeItem(String code) {
        jdbcTemplate.update(SQL_DELETE_ITEM, code);
    }

    @Override
    public void updateItem(Item item) {
        jdbcTemplate.update(SQL_UPDATE_ITEM,
                item.getName(),
                item.getCode(),
                item.getCost(),
                item.getCount());
    }

    @Override
    public List<Item> getAllItems() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ITEMS, new ContactMapper());
    }

    @Override
    public Item findItemByCode(String code) {
        try {
        return jdbcTemplate.queryForObject(SQL_SELECT_ITEM, new ContactMapper(), code);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Item> searchItems(Map<SearchTerm, String> criteria) {
        if (criteria.size() == 0) {
            return getAllItems();
        } else {
            StringBuilder sQuery = new StringBuilder("select * from items where ");
            
            // build the where clause
            int numParams = criteria.size();
            int paramPosition = 0;
            String[] paramVals = new String[numParams];
            
            Set<SearchTerm> keySet = criteria.keySet();
            Iterator<SearchTerm> iter = keySet.iterator();
            while(iter.hasNext()) {
                SearchTerm currentKey = iter.next();
                if (paramPosition > 0) {
                    sQuery.append(" and ");
                }
                
                sQuery.append(currentKey);
                sQuery.append(" = ? ");
                
                paramVals[paramPosition] = criteria.get(currentKey);
                paramPosition++;
            }
            
            return jdbcTemplate.query(sQuery.toString(), new ContactMapper(), paramVals);
        }
    }

    @Override
    public void lowerItemCount(String code) {
        jdbcTemplate.update(SQL_LOWER_COUNT, code);
    }

    @Override
    public int returnItemInventory(Item name) {
        return jdbcTemplate.update(SQL_ITEM_COUNT, name);
    }
    
    private static final class ContactMapper implements ParameterizedRowMapper<Item> {

        @Override
        public Item mapRow(ResultSet rs, int i) throws SQLException {
            Item item = new Item();
            item.setName(rs.getString("name"));
            item.setCode(rs.getString("code"));
            item.setCost(rs.getBigDecimal("cost"));
            item.setCount(rs.getInt("count"));
            return item;
        }
        
    }
}
