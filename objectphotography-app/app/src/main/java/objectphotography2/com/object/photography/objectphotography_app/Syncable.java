// Syncable object
// @author: msenol
package objectphotography2.com.object.photography.objectphotography_app;
public interface Syncable
{
    /**
     * Set status
     * @param syncStatus - status of sync
     */
    public void setSyncStatus(String syncStatus);

    /**
     * Get status
     * @return Returns sync status
     */
    public String getSyncStatus();
}