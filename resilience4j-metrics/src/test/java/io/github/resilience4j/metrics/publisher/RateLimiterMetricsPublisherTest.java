/*
 * Copyright 2019 Ingyu Hwang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.resilience4j.metrics.publisher;

import com.codahale.metrics.MetricRegistry;
import io.github.resilience4j.metrics.AbstractRateLimiterMetricsTest;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;

public class RateLimiterMetricsPublisherTest extends AbstractRateLimiterMetricsTest {

    @Override
    protected RateLimiter given(String prefix, MetricRegistry metricRegistry) {
        RateLimiterRegistry rateLimiterRegistry =
                RateLimiterRegistry.of(RateLimiterConfig.ofDefaults(), new RateLimiterMetricsPublisher(prefix, metricRegistry));

        return rateLimiterRegistry.rateLimiter("testLimit");
    }

    @Override
    protected RateLimiter given(MetricRegistry metricRegistry) {
        RateLimiterRegistry rateLimiterRegistry =
                RateLimiterRegistry.of(RateLimiterConfig.ofDefaults(), new RateLimiterMetricsPublisher(metricRegistry));

        return rateLimiterRegistry.rateLimiter("testLimit");
    }

}