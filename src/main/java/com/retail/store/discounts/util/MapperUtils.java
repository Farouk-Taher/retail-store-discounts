package com.retail.store.discounts.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Farouk Taher
 * Date: 19-12-2020
 * Time: 5:47 PM
 */
@Data
@Slf4j
public class MapperUtils {
    private static ObjectMapper mapper = new ObjectMapper();
    private static MapperUtils INSTANCE = new MapperUtils();

    /**
     *
     */
    private MapperUtils() {
        mapper.configure(SerializationFeature.WRITE_CHAR_ARRAYS_AS_JSON_ARRAYS, true);
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    }

    /**
     * @param source object to be parsed
     * @param clazz  target class
     * @return object of the passed class type
     */
    public static <D> D map(final Object source, final Class<D> clazz) throws Exception {
        if (source == null || clazz == null) {
            return null;
        }
        final D target = clazz.getDeclaredConstructor().newInstance();
        BeanUtils.copyProperties(source, target);
        return target;
    }

    /**
     * @param source list of objects to be parsed
     * @param clazz  target class
     * @return object of the passed class type
     */
    public static <D> List<D> mapAll(final List<Object> source, final Class<D> clazz) throws Exception {
        if (source == null || source.size() == 0 || clazz == null) {
            return null;
        }
        List<D> list = new ArrayList<>();
        for (Object o : source) {
            list.add(map(o, clazz));
        }
        return list;
    }

    /**
     * @param source object to be parsed
     * @param target target class
     * @return object of the passed class type
     */
    public static <D> D map(final Object source, final D target) {
        if (source == null || target == null) {
            return null;
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }

    public static Map<String, Object> map(final Object source) throws Exception {
        if (source == null) {
            return null;
        }
        return PropertyUtils.describe(source);
    }

    public static <T> T convertValue(Object fromValue, TypeReference<T> toValueTypeRef) {
        return mapper.convertValue(fromValue, toValueTypeRef);
    }

    public static <T> T convertValue(Object fromValue, Class<T> toValueType) {
        return mapper.convertValue(fromValue, toValueType);
    }

}
