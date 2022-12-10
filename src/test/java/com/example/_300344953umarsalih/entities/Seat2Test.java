package com.example._300344953umarsalih.entities;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;

@RunWith(MockitoJUnitRunner.class)
class Seat2Test {

    JdbcTemplate mockJdbcTemplate = mock(JdbcTemplate.class);

    Seat2 seat = new Seat2(mockJdbcTemplate);



    @Test
    void display() throws SQLException, ClassNotFoundException {
        Seat s =new Seat();

        long i = 12345678910L;

        Date d1 = new Date();


        s.setId(i);
        s.setSeatNo("2B");
        s.setReservationDate(d1);
        s.setName("Lu");

        List<Seat> ll =new ArrayList<>();

        ll.add(s);

        when(mockJdbcTemplate.query(anyString(),any(RowMapper.class))).thenReturn(ll);

        List<Seat> ssl = seat.display();

        assertEquals(1, ssl.size());
    }
}