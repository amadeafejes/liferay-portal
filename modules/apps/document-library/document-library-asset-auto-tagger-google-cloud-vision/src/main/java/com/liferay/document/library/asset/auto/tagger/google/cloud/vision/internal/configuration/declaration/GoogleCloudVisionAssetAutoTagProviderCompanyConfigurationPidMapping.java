/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.document.library.asset.auto.tagger.google.cloud.vision.internal.configuration.declaration;

import com.liferay.document.library.asset.auto.tagger.google.cloud.vision.internal.configuration.GoogleCloudVisionAssetAutoTagProviderCompanyConfiguration;
import com.liferay.document.library.asset.auto.tagger.google.cloud.vision.internal.constants.GoogleCloudVisionAssetAutoTagProviderConstants;
import com.liferay.portal.kernel.settings.definition.ConfigurationPidMapping;

import org.osgi.service.component.annotations.Component;

/**
 * @author Alejandro Tardín
 */
@Component(service = ConfigurationPidMapping.class)
public class GoogleCloudVisionAssetAutoTagProviderCompanyConfigurationPidMapping
	implements ConfigurationPidMapping {

	@Override
	public Class<?> getConfigurationBeanClass() {
		return GoogleCloudVisionAssetAutoTagProviderCompanyConfiguration.class;
	}

	@Override
	public String getConfigurationPid() {
		return GoogleCloudVisionAssetAutoTagProviderConstants.SERVICE_NAME;
	}

}