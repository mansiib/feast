/*
 * Copyright 2018 The Feast Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package feast.serving.config;

import io.grpc.ServerBuilder;
import java.util.concurrent.ExecutorService;
import org.lognet.springboot.grpc.GRpcServerBuilderConfigurer;
import org.springframework.stereotype.Component;

/**
 * Configuration for Grpc server.
 */
@Component
public class GrpcServerConfigurer extends GRpcServerBuilderConfigurer {

  private final ExecutorService executorService;

  public GrpcServerConfigurer(
      ExecutorService executorService) {
    this.executorService = executorService;
  }

  @Override
  public void configure(ServerBuilder<?> serverBuilder) {
    serverBuilder.executor(executorService);
  }
}
