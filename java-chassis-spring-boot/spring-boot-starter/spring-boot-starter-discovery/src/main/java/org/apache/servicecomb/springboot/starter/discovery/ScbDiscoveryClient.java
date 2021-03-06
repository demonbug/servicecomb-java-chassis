/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.servicecomb.springboot.starter.discovery;

import java.util.List;

import org.apache.servicecomb.foundation.common.net.URIEndpointObject;
import org.apache.servicecomb.springboot.common.AbstractDiscoveryClient;
import org.apache.servicecomb.springboot.common.InstanceDiscoveryFilter;
import org.springframework.cloud.client.DefaultServiceInstance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

public class ScbDiscoveryClient extends AbstractDiscoveryClient implements DiscoveryClient {

  public ScbDiscoveryClient() {
    super(new InstanceDiscoveryFilter((String name, URIEndpointObject uri) ->
        new DefaultServiceInstance(name, uri.getHostOrIp(), uri.getPort(), uri.isSslEnabled())));
  }

  @Override
  public String description() {
    return "Spring Cloud CSE Discovery Client";
  }

  @Override
  @Deprecated
  public ServiceInstance getLocalServiceInstance() {
    return null;
  }

  public List<ServiceInstance> getInstances(String serviceId) {
    return super.doGetInstances(serviceId);
  }
}
