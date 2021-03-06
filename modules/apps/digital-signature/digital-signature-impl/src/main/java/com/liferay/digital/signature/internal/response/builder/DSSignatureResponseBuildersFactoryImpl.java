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

package com.liferay.digital.signature.internal.response.builder;

import com.liferay.digital.signature.response.builder.DSSignatureResponseBuilder;
import com.liferay.digital.signature.response.builder.DSSignatureResponseBuildersFactory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Michael C. Han
 */
@Component(service = DSSignatureResponseBuildersFactory.class)
public class DSSignatureResponseBuildersFactoryImpl
	implements DSSignatureResponseBuildersFactory {

	@Override
	public DSSignatureResponseBuilder createDSSignatureResponseBuilder(
		String dsSignatureRequestKey) {

		return new DSSignatureResponseBuilderImpl(dsSignatureRequestKey);
	}

}