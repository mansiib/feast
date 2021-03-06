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

package feast.ingestion.deserializer;

import com.google.protobuf.InvalidProtocolBufferException;
import feast.types.FeatureRowProto.FeatureRow;
import java.util.Map;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

/**
 * Deserializer for Kafka to deserialize Protocol Buffers messages
 *
 * @param <FeatureRow> Protobuf message type
 */
public class FeatureRowDeserializer implements Deserializer<FeatureRow> {

  @Override
  public void configure(Map configs, boolean isKey) {}

  @Override
  public FeatureRow deserialize(String topic, byte[] data) {
    try {
      return FeatureRow.parseFrom(data);
    } catch (InvalidProtocolBufferException e) {
      throw new SerializationException("Error deserializing FeatureRow from Protobuf message", e);
    }
  }

  @Override
  public void close() {}
}
