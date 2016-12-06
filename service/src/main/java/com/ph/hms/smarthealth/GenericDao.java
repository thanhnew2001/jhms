package com.ph.hms.smarthealth;

import java.util.Collection;

public interface GenericDao<T>
{
    /**
     * Saves the given object instance.
     * 
     * @param object the object instance.
     * @return the generated identifier.
     */
    int save( T object );
    
    /**
     * Updates the given object instance.
     * 
     * @param object the object instance.
     */
    void update( T object );
    
    /**
     * Saves or updates the given object instance depending on the object's
     * persistent state.
     * 
     * @param object the object instance.
     */
    void saveOrUpdate( T object );
    
    /**
     * Retrieves the object with the given identifier. This method will first
     * look in the current Session, then hit the database if not existing.
     * 
     * @param id the object identifier.
     * @return the object identified by the given identifier.
     */
    T get(Class claz, int id );
    
    /**
     * Retrieves the object with the given identifier, assuming it exists.
     * 
     * @param id the object identifier.
     * @return the object identified by the given identifier or a generated proxy.
     */
    T load(Class claz, int id );
    
    /**
     * Retrieves a Collection of all objects.
     * 
     * @return a Collection of all objects.
     */
    Collection<T> getAll(Class claz);
    
    /**
     * Removes the given object instance.
     * 
     * @param object the object instance to delete.
     */
    void delete( T object );
    
    Collection<T> search(Class claz, String col, String con, int pageSize, int page );
}
