/*
 * Copyright 2012-2019 the original author or authors.
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

package org.springframework.cloud.config.server.encryption;

import java.util.Map;

import org.springframework.security.crypto.encrypt.TextEncryptor;

/**
 * @author Dave Syer
 *
 */
public class LocatorTextEncryptor implements TextEncryptor {

	private EnvironmentPrefixHelper helper = new EnvironmentPrefixHelper();

	private TextEncryptorLocator locator;

	public LocatorTextEncryptor(TextEncryptorLocator locator) {
		this.locator = locator;
	}

	@Override
	public String encrypt(String text) {
		Map<String, String> keys = this.helper.getEncryptorKeys("configserver", "default", text);
		return getLocator().locate(keys).encrypt(this.helper.stripPrefix(text));
	}

	private TextEncryptorLocator getLocator() {
		return this.locator;
	}

	@Override
	public String decrypt(String encryptedText) {
		Map<String, String> keys = this.helper.getEncryptorKeys("configserver", "default", encryptedText);
		return getLocator().locate(keys).decrypt(this.helper.stripPrefix(encryptedText));
	}

}
