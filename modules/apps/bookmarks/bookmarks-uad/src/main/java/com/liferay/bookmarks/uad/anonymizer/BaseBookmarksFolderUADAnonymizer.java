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

package com.liferay.bookmarks.uad.anonymizer;

import com.liferay.bookmarks.model.BookmarksFolder;
import com.liferay.bookmarks.service.BookmarksFolderLocalService;
import com.liferay.bookmarks.uad.constants.BookmarksUADConstants;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.user.associated.data.anonymizer.DynamicQueryUADAnonymizer;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the bookmarks folder UAD anonymizer.
 *
 * <p>
 * This implementation exists only as a container for the default methods
 * generated by ServiceBuilder. All custom service methods should be put in
 * {@link BookmarksFolderUADAnonymizer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class BaseBookmarksFolderUADAnonymizer
	extends DynamicQueryUADAnonymizer<BookmarksFolder> {

	@Override
	public void autoAnonymize(
			BookmarksFolder bookmarksFolder, long userId, User anonymousUser)
		throws PortalException {

		if (bookmarksFolder.getUserId() == userId) {
			bookmarksFolder.setUserId(anonymousUser.getUserId());
			bookmarksFolder.setUserName(anonymousUser.getFullName());
		}

		if (bookmarksFolder.getStatusByUserId() == userId) {
			bookmarksFolder.setStatusByUserId(anonymousUser.getUserId());
			bookmarksFolder.setStatusByUserName(anonymousUser.getFullName());
		}

		bookmarksFolderLocalService.updateBookmarksFolder(bookmarksFolder);
	}

	@Override
	public void delete(BookmarksFolder bookmarksFolder) throws PortalException {
		bookmarksFolderLocalService.deleteFolder(bookmarksFolder);
	}

	@Override
	public Class<BookmarksFolder> getTypeClass() {
		return BookmarksFolder.class;
	}

	@Override
	protected ActionableDynamicQuery doGetActionableDynamicQuery() {
		return bookmarksFolderLocalService.getActionableDynamicQuery();
	}

	@Override
	protected String[] doGetUserIdFieldNames() {
		return BookmarksUADConstants.USER_ID_FIELD_NAMES_BOOKMARKS_FOLDER;
	}

	@Reference
	protected BookmarksFolderLocalService bookmarksFolderLocalService;

}