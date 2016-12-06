package com.ph.hms.config;

import java.util.Properties;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HibernatePropertiesProvider
    implements FactoryBean
{
    private static final String DEFAULT_CONFIG_FILE = "hibernate-default.properties";

    // -------------------------------------------------------------------------
    // Factory bean implementation
    // -------------------------------------------------------------------------

    public Object getObject()
        throws Exception
    {
        Resource config = new ClassPathResource( DEFAULT_CONFIG_FILE );
        
        Properties props = new Properties();
        
        props.load( config.getInputStream() );
        
        return props;
    }

    public Class<?> getObjectType()
    {
        return Properties.class;
    }

    public boolean isSingleton()
    {
        return true;
    }
}
