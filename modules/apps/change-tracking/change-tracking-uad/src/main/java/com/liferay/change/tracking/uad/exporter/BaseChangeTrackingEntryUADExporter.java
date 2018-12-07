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

package com.liferay.change.tracking.uad.exporter;

import com.liferay.change.tracking.model.ChangeTrackingEntry;
import com.liferay.change.tracking.service.ChangeTrackingEntryLocalService;
import com.liferay.change.tracking.uad.constants.ChangeTrackingUADConstants;

import com.liferay.petra.string.StringBundler;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;

import com.liferay.user.associated.data.exporter.DynamicQueryUADExporter;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the change tracking entry UAD exporter.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom service methods should be put in
 * {@link ChangeTrackingEntryUADExporter}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BaseChangeTrackingEntryUADExporter
	extends DynamicQueryUADExporter<ChangeTrackingEntry> {
	@Override
	public Class<ChangeTrackingEntry> getTypeClass() {
		return ChangeTrackingEntry.class;
	}

	@Override
	protected ActionableDynamicQuery doGetActionableDynamicQuery() {
		return changeTrackingEntryLocalService.getActionableDynamicQuery();
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return ChangeTrackingUADConstants.USER_ID_FIELD_NAMES_CHANGE_TRACKING_ENTRY;
	}

	@Override
	protected String toXmlString(ChangeTrackingEntry changeTrackingEntry) {
		StringBundler sb = new StringBundler(13);

		sb.append("<model><model-name>");
		sb.append("com.liferay.change.tracking.model.ChangeTrackingEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>changeTrackingEntryId</column-name><column-value><![CDATA[");
		sb.append(changeTrackingEntry.getChangeTrackingEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(changeTrackingEntry.getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(changeTrackingEntry.getUserName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	@Reference
	protected ChangeTrackingEntryLocalService changeTrackingEntryLocalService;
}