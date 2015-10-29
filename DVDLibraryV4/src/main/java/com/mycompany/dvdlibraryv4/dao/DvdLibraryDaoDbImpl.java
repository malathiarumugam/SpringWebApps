


package com.mycompany.dvdlibraryv4.dao;

import com.mycompany.dvdlibraryv4.model.DVD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;


public class DvdLibraryDaoDbImpl implements DvdLibraryDao {
    
    private static final String SQL_INSERT_MOVIE = 
            "insert into movies (title, release_date, mpaa_rating, director, studio, note) values (?, ?, ?, ?, ?, ?)";
    
    private static final String SQL_DELETE_MOVIE = 
            "delete from movies where id = ?";
    
    private static final String SQL_SELECT_MOVIE = 
            "select * from movies where id = ?";
    
    private static final String SQL_SELECT_ALL_MOVIES = 
            "select * from movies";
    
    private static final String SQL_UPDATE_MOVIE = 
            "update movies set title = ?, release_date = ?, mpaa_rating = ?, director = ?, studio = ?, note = ? where id = ?";
    
    private JdbcTemplate jdbcTemplate;
    
    public void setjdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    

    @Override
    public DVD addDVD(DVD dvd) {
        jdbcTemplate.update(SQL_INSERT_MOVIE,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getMpaaRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getNote());
        dvd.setId(jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class));
        return dvd;
    }

    @Override
    public void removeDVD(int DVDId) {
        jdbcTemplate.update(SQL_DELETE_MOVIE, DVDId);
    }

    @Override
    public void updateDVD(DVD dvd) {
        jdbcTemplate.update(SQL_UPDATE_MOVIE,
                dvd.getTitle(),
                dvd.getReleaseDate(),
                dvd.getMpaaRating(),
                dvd.getDirector(),
                dvd.getStudio(),
                dvd.getNote(),
                dvd.getId());
    }

    @Override
    public List<DVD> getAllDVDs() {
        return jdbcTemplate.query(SQL_SELECT_ALL_MOVIES, new DvdMapper());
    }

    @Override
    public DVD getDVDById(int DVDId) {
              try {
        return jdbcTemplate.queryForObject(SQL_SELECT_MOVIE, new DvdMapper(), DVDId);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<DVD> searchDVDs(Map<SearchTerm, String> criteria) {
        if (criteria.size() == 0) {
            return getAllDVDs();
        } else {
            StringBuilder sQuery = new StringBuilder("select * from movies where ");
            
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
            
            return jdbcTemplate.query(sQuery.toString(), new DvdMapper(), paramVals);
        }
    }
    
    private static final class DvdMapper implements ParameterizedRowMapper<DVD> {

        @Override
        public DVD mapRow(ResultSet rs, int i) throws SQLException {
            DVD dvd = new DVD();
            dvd.setId(rs.getInt("id"));
            dvd.setTitle(rs.getString("title"));
            dvd.setReleaseDate(rs.getString("release_date"));
            dvd.setMpaaRating(rs.getString("mpaa_rating"));
            dvd.setDirector(rs.getString("director"));
            dvd.setStudio(rs.getString("studio"));
            dvd.setNote(rs.getString("note"));
            return dvd;
        }
        
    }

}
