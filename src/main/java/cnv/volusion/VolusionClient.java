/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.volusion;

import cnv.volusion.services.BaseService;

/**
 *
 * @author Naga Srinivas @Canvass
 */
public interface VolusionClient {

    public void enableDebug();

    public void disableDebug();

    public boolean isDebugEnabled();

    public String getBaseUrl();

    public Credentials getCredentials();

    public <T extends BaseService> T getService(Class<T> cls) throws InstantiationException, IllegalAccessException;
}
