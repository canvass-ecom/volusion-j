/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cnv.volusion.services;

import cnv.volusion.VolusionClientImpl;
import java.io.IOException;
import java.util.Scanner;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author Naga Srinivas @Canvass
 */
public class BaseService {

    protected VolusionClientImpl client;
    protected String baseUrl;

    BaseService() {
    }

    public VolusionClientImpl getClient() {
        return client;
    }

    public void setClient(VolusionClientImpl client) {
        this.client = client;
        this.baseUrl = client.getBaseUrl();
    }

    protected String execute(HttpUriRequest request) throws IOException {
        boolean debug = client.isDebugEnabled();
        StringBuilder buff = new StringBuilder();
        request.addHeader("Content-Type", "text/xml; charset=utf-8");
        request.addHeader("Content-Action", "Volusion_API");

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            CloseableHttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            Scanner in = new Scanner(entity.getContent());
            if (debug) {
                System.out.println("Status Line: " + request.getRequestLine());
                System.out.println("Status Code: " + response.getStatusLine());
            }
            while (in.hasNext()) {
                String line = in.nextLine();
                buff.append(line);
            }
            if (debug) {
                System.out.println(buff.toString());
            }
        } catch (Exception e) {
        } finally {
            httpClient.close();
        }
        return buff.toString();
    }
}
