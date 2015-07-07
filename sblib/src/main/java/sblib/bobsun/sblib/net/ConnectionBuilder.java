package sblib.bobsun.sblib.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import sblib.bobsun.sblib.util.StringUtil;

/**
 * Created by bobsun on 15-7-7.
 */

/**
 * A ConnectionBuilder is a connection builder, which you can get an HttpURLConnection from it.
 * Besides, you can write or read data from a initialized ConnectionBuilder object.
 */
public class ConnectionBuilder {

    private String url;
    private String method = "GET";
    private int timeout = 60000;
    private boolean doInput = true;
    private boolean doOutput = true;
    private HttpURLConnection connection;

    public ConnectionBuilder(){

    }

    /**
     * Set the url
     * @param url
     * @return
     */
    public ConnectionBuilder setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Set request method, default GET
     * @param method Request method, only "GET" & "POST" allowed here.
     * @return
     */
    public ConnectionBuilder setMethod(String method) {
        if (method.equalsIgnoreCase("POST") || method.equalsIgnoreCase("GET"))
            this.method = method;
        return this;
    }

    /**
     * Set connection timeout
     * @param timeout   Timeout value.
     * @return
     */
    public ConnectionBuilder setTimeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public void setDoInput(boolean doInput) {
        this.doInput = doInput;
    }

    public void setDoOutput(boolean doOutput) {
        this.doOutput = doOutput;
    }

    /**
     * Get HttpURLConnection.
     * Use the return vale directly or use wrapped read & write function.
     * @return
     * @throws IOException
     */
    public HttpURLConnection getConnection() throws IOException  {
        if (StringUtil.isNullOrEmpty(url))
            throw new NullPointerException("Url can not be null!");
        HttpURLConnection ret = (HttpURLConnection) new URL(url).openConnection();
        ret.setRequestMethod(method);
        ret.setDoInput(doInput);
        ret.setDoOutput(doOutput);
        ret.setConnectTimeout(timeout);
        this.connection = ret;
        return ret;
    }

    /**
     * Write data to url connection.
     * @param data  Data to be written.
     * @throws IOException
     */
    public void writeDataToConnection(String data) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(
                connection.getOutputStream()
        );
        writer.write(data);
        writer.flush();
        writer.close();
    }

    public void writeDataToConnection(byte[] data){

    }

    /**
     * Get response from connection.
     * @return Response data.
     * @throws IOException
     */
    public String getResponseFromConnection() throws IOException {
        if (connection == null){
            getConnection();
        }
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream())
        );
        StringBuilder builder = new StringBuilder();
        String buffer;
        while ((buffer = reader.readLine()) != null){
            builder.append(buffer);
        }
        return builder.toString();
    }
}
