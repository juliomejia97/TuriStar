package com.webDevelopment.turistar.User.User.Infrastructure.Hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.HotelPlanBookingDetail;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.TourBookingDetail;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class HotelPlanBookingCustomDetail implements UserType {
    @Override
    public int[] sqlTypes() {
        return new int[] {Types.LONGNVARCHAR};
    }

    @Override
    public Class returnedClass() {
        return List.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        return Objects.equals(x, y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return Objects.hashCode(x);
    }

    @Override
    public Object nullSafeGet(ResultSet rs, String[] names, SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        List<HotelPlanBookingDetail> response = null;
        try {
            Optional<String> value = Optional.ofNullable(rs.getString(names[0]));
            if(value.isPresent()) {
                List<HashMap<String, Object>> objects = new ObjectMapper().readValue(value.get(), List.class);
                response = objects.stream().map(tourSpot ->
                        new HotelPlanBookingDetail((String) tourSpot.get("id"),
                                (LocalDate) tourSpot.get("initDate"),
                                (LocalDate) tourSpot.get("endDate"))).collect(Collectors.toList());
            }
        }
        catch (Exception e){
            throw new HibernateException("Error at reading map", e);
        }
        return Optional.ofNullable(response);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        Optional<List<HotelPlanBookingDetail>> colors = (value == null) ? Optional.empty() : (Optional<List<HotelPlanBookingDetail>>) value;
        try {
            if(colors.isEmpty()) {
                st.setNull(index, Types.VARCHAR);
            }
            else {
                ObjectMapper mapper = new ObjectMapper();
                List<HashMap<String, Object>> objects = colors.get().stream().map(HotelPlanBookingDetail::data).collect(Collectors.toList());
                String serializedList = mapper.writeValueAsString(objects).replace("\\", "");
                st.setString(index,serializedList);
            }
        }
        catch (Exception e) {
            throw new HibernateException("Exception serializing value " + value, e);
        }
    }

    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return null;
    }

    @Override
    public boolean isMutable() {
        return false;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return null;
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return null;
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return null;
    }
}
