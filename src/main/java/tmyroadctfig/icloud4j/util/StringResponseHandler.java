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


import com.google.common.io.CharStreams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

/**
 * A response handler which returns the response content as a string.
 *
 * @author Luke Quinane
 */
public class StringResponseHandler implements ResponseHandler<String>
{
    @Override
    public String handleResponse(HttpResponse response) throws IOException
    {
        HttpEntity respEntity = response.getEntity();
        if (respEntity != null) {
            Reader reader = new InputStreamReader(respEntity.getContent(), Charset.forName("UTF-8"));
            return CharStreams.toString(reader);
        }

        return null;
    }
}
