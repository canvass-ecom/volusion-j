/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.volusion;

import cnv.volusion.services.BaseService;
import java.io.IOException;

/**
 *
 * @author Naga Srinivas @Canvass
 */
public class VolusionClientImpl implements VolusionClient {

    private Credentials creds;
    String baseUrl;
    private boolean debug = false;

    @Override
    public void enableDebug() {
        debug = true;
    }

    @Override
    public void disableDebug() {
        debug = false;
    }

    @Override
    public boolean isDebugEnabled() {
        return debug;
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    public VolusionClientImpl(Credentials creds) throws InstantiationException, IllegalAccessException, IOException {
        this.creds = creds;
        this.baseUrl = "http://v2208768.ynpjwxbodko5.demo37.volusion.com/net/WebService.aspx";
    }

    @Override
    public Credentials getCredentials() {
        return creds;
    }

    /**
     * This method will create the Given Service
     *
     * @param <T>
     * @param cls Service Class
     * @return the Service Object
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Override
    public final <T extends BaseService> T getService(Class<T> cls) throws InstantiationException, IllegalAccessException {
        T obj = cls.newInstance();
        obj.setClient(this);
        return obj;
    }

    public static String getStoreUrl(String storeHash) {
        return "https://store-" + storeHash + ".mybigcommerce.com";
    }
}
