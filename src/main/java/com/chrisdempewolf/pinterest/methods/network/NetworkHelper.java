package com.chrisdempewolf.pinterest.methods.network;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class NetworkHelper {

    public static ResponseMessageAndStatusCode submitDeleteRequest(final HttpDelete httpDelete) throws IOException {
        return submitRequest(httpDelete);
    }

    public static ResponseMessageAndStatusCode submitPostRequest(final HttpPost httpPost) throws IOException {
        return submitRequest(httpPost);
    }

    private static ResponseMessageAndStatusCode submitRequest(final HttpRequestBase httpRequestBase) throws IOException {
        try (final CloseableHttpResponse response = HttpClients.createDefault().execute(httpRequestBase)) {
            final String responseBody = EntityUtils.toString(response.getEntity());
            final int statusCode = response.getStatusLine().getStatusCode();

            return new ResponseMessageAndStatusCode(statusCode, responseBody);
        }
    }
}
