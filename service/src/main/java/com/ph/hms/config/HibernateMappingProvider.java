package com.ph.hms.config;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HibernateMappingProvider
    implements FactoryBean
{
    // -------------------------------------------------------------------------
    // FactoryBean implementation
    // -------------------------------------------------------------------------

    public Object getObject()
        throws Exception
    {
        Resource[] locations = { new ClassPathResource( "com/ph/hms/" ) };
        
        return locations;
    }

    public Class<?> getObjectType()
    {
        return Resource.class;
    }

    public boolean isSingleton()
    {
        return true;
    }
}
