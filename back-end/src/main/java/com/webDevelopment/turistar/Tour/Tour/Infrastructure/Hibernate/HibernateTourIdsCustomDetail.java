package com.webDevelopment.turistar.Tour.Tour.Infrastructure.Hibernate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webDevelopment.turistar.Administrator.Hotel.Domain.ValueObjects.HotelPhoto;
import com.webDevelopment.turistar.Shared.Domain.TourSpot.TourSpotId;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class HibernateTourIdsCustomDetail implements UserType {
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
        List<TourSpotId> response = null;
        try {
            Optional<String> value = Optional.ofNullable(rs.getString(names[0]));
            if(value.isPresent()) {
                List<String> objects = new ObjectMapper().readValue(value.get(), List.class);
                response = objects.stream().map(TourSpotId::new).collect(Collectors.toList());
            }
        }
        catch (Exception e){
            throw new HibernateException("Error at reading map", e);
        }
        return Optional.ofNullable(response);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value, int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        Optional<List<TourSpotId>> tourSpotIds = (value == null) ? Optional.empty() : (Optional<List<TourSpotId>>) value;
        try {
            if(tourSpotIds.isEmpty()) {
                st.setNull(index, Types.VARCHAR);
            }
            else {
                ObjectMapper mapper = new ObjectMapper();
                List<String> objects = tourSpotIds.get().stream().map(tourSpotId -> tourSpotId.value()).collect(Collectors.toList());
                String serializedList = mapper.writeValueAsString(objects).replace("\\", "");
                st.setString(index, serializedList);
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
