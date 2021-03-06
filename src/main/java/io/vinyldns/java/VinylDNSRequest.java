/**
 * Copyright 2018 Comcast Cable Communications Management, LLC
 *
 * <p>Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 * <p>http://www.apache.org/licenses/LICENSE-2.0
 *
 * <p>Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vinyldns.java;

import com.amazonaws.http.HttpMethodName;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VinylDNSRequest<T> {

  private final Map<String, String> headers = new HashMap<>();
  private final Map<String, List<String>> parameters = new HashMap<>();
  private final URI uri;
  private final HttpMethodName methodName;
  private final String resourcePath;
  private final T payload;

  public VinylDNSRequest(String method, String url, String path, T payload) {
    this.uri = URI.create(url);
    this.payload = payload;
    this.methodName = HttpMethodName.valueOf(method);
    this.resourcePath = path;
  }

  public void addHeader(String name, String value) {
    headers.put(name, value);
  }

  public void addParameter(String name, String value) {
    List<String> match = parameters.getOrDefault(name, new ArrayList<String>());
    match.add(value);
    parameters.put(name, match);
  }

  public T getPayload() {
    return payload;
  }

  public Map<String, String> getHeaders() {
    return headers;
  }

  public String getResourcePath() {
    return resourcePath;
  }

  public Map<String, List<String>> getParameters() {
    return parameters;
  }

  public URI getEndpoint() {
    return uri;
  }

  public HttpMethodName getHttpMethod() {
    return methodName;
  }
}
