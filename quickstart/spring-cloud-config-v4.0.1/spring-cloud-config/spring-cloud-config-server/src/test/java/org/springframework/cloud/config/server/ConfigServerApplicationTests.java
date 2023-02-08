/*
 * Copyright 2013-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.config.server;

import org.apache.catalina.webresources.TomcatURLStreamHandlerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.test.ClassPathExclusions;
import org.springframework.cloud.test.ModifiedClassPathRunner;
import org.springframework.context.ConfigurableApplicationContext;

@RunWith(ModifiedClassPathRunner.class)
@ClassPathExclusions("h2-*.jar")
public class ConfigServerApplicationTests {

	static {
		TomcatURLStreamHandlerFactory.disable();
	}

	@Test
	public void contextLoads() {
		try (ConfigurableApplicationContext context = new SpringApplicationBuilder(ConfigServerApplication.class)
				.properties("spring.config.name=configserver").run("--server.port=0")) {
			// empty
		}
	}

}
