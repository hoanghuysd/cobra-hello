package org.cobra.app.common.jdbc;

import org.cobra.app.common.fileloader.CommonFileLoader;
import org.cobra.web.error.exception.CbIOFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;
import java.util.Set;


/**
 * Created by Hoang Huy on 11/5/2017.
 */
@Component
public class CbEntityManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(CbEntityManager.class);

    private final String INS_ACTION = "insAction";
    private final String INS_DATE = "insDate";
    private final String UPD_ACTION = "updAction";
    private final String UPD_DATE = "upDateDate";

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private CommonFileLoader commonFileLoader;

    /**
     * @param entity
     */
    public void persist(Object entity) {
        entityManager.persist(entity);
    }

    public Query createQuery(Class clazz, String path) throws CbIOFileException {
        Query query = entityManager.createQuery(commonFileLoader.reader(path));
        return query;
    }

    public Query createQuery(Class clazz, String path, Object params) {
        try {
            return createQueryParam(clazz, path, params);
        } catch (CbIOFileException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param qlString
     * @return
     */
    public Query createQuery(String qlString) {
        return entityManager.createQuery(qlString);
    }

    /**
     * @param qlString
     * @param resultClass
     * @param <T>
     * @return
     */
    public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
        return entityManager.createQuery(qlString, resultClass);
    }

    /**
     *
     */
    public void flush() {
        entityManager.flush();
    }

    /**
     * @param entity
     */
    public void remove(Object entity) {
        entityManager.remove(entity);
    }

    public <T> T find(Class<T> entityClass, Object primaryKey) {
        return entityManager.find(entityClass, primaryKey);
    }

    private <T> Query createQueryParam(Class<T> clazz, String path, Object params) throws CbIOFileException, IllegalAccessException {
        String hql = commonFileLoader.reader(path);
        Query query = entityManager.createQuery(hql, clazz);
        query.setMaxResults(5);
        Object ob =query.getParameters();
        Set<? extends Parameter> parameters = query.getParameters();
        if (params != null) {
            if (BeanUtils.isSimpleValueType(clazz)|| params instanceof Collection) {
                if(parameters.size()==1) {
                    for (Parameter data : parameters) {
                        query.setParameter(data.getName(), params);
                    }
                }
            } else if (params instanceof Map) {
                Map<String, Object> paramMap = (Map) params;
                if (!paramMap.isEmpty() && !parameters.isEmpty()) {
                    for (Parameter data : parameters) {
                        Object obj = paramMap.get(data.getName());
                        if (obj != null) {
                            query.setParameter(data.getName(), obj);
                        }
                    }
                }
            } else {
                Field[] fields = params.getClass().getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    for (Parameter data : parameters) {
                        if (data.getName().equals(field.getName())) {
                            query.setParameter(field.getName(), field.get(params));
                        }
                    }
                }
            }
        }
        if(!parameters.isEmpty()){
            for (Parameter data : parameters) {
                setDefaultParam(data,query);
            }
        }
        return query;
    }

    private void setDefaultParam(Parameter param, Query query) {
        if (param.getName().equals(INS_ACTION)) {
            query.setParameter(INS_ACTION,"");
        } else if (param.getName().equals(INS_DATE)) {
            query.setParameter(INS_DATE,"");
        } else if (param.getName().equals(UPD_ACTION)) {
            query.setParameter(UPD_ACTION,"");
        } else if (param.getName().equals(UPD_DATE)) {
            query.setParameter(UPD_DATE,"");
        }
    }
}
