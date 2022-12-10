package com.example._300344953umarsalih.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Component
@Service
public class Seat2 {

    @Autowired
    JdbcTemplate template;

    public Seat2(JdbcTemplate template) {
        this.template = template;
    }

    public List<Seat> display() throws ClassNotFoundException, SQLException {
        return template.query("select * from seat", (RowMapper) (rs, row) -> {
            Seat s = new Seat();
            s.setId(rs.getLong(1));
            s.setReservationDate(rs.getDate(2));
            s.setSeatNo(rs.getString(3));
            s.setName(rs.getString(4));
            return s;
        });
    }

//    public int insertDate(final Seat2 seat2) {
//        return template.update("insert into customer values (?,?,?)", seat2.getDate(0), );
//    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public List<Map<String, Object>> getId (String id) {
        return template.queryForList("select ids from seat where Id = ?", id);
    }

    public List<Map<String, Object>> getDate (String id) {
        return template.queryForList("select date from seat where Id = ?", id);
    }

//    public List<Map<String, Object>> getSeatNum (String id) {
//        return template.queryForList("select * from seat where Id = ?", id);
//    }
//
//    public List<Map<String, Object>> getName (String id) {
//        return template.queryForList("select * from seat where Id = ?", id);
//    }
}

