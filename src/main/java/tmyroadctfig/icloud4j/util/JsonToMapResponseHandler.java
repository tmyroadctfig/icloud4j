/*
 *    Copyright 2016 Luke Quinane
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package tmyroadctfig.icloud4j.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * A response handler that converts a JSON response to a map of key/value pairs.
 *
 * @author Nick DS (me@nickdsantos.com)
 * @author Luke Quinane
 */
public class JsonToMapResponseHandler implements ResponseHandler<Map<String,Object>>
{
    /**
     * The logger.
     */
    private static final Logger logger = Logger.getLogger(JsonToMapResponseHandler.class);

    @Override
    public Map<String, Object> handleResponse(HttpResponse response) throws IOException
    {
        StatusLine statusLine = response.getStatusLine();
        if (logger.isDebugEnabled())
        {
            logger.debug("code: " + statusLine.getStatusCode() + "; reason: " + statusLine.getReasonPhrase());
        }

        HttpEntity respEntity = response.getEntity();
        if (respEntity != null)
        {
            Gson gson = new GsonBuilder().create();
            Reader reader = new InputStreamReader(respEntity.getContent(), Charset.forName("UTF-8"));
            return gson.<Map<String, Object>>fromJson(reader, Map.class);
        }

        return null;
    }
}