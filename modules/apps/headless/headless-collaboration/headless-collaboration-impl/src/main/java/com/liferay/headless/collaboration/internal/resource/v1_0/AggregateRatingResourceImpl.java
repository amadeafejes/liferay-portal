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

package com.liferay.headless.collaboration.internal.resource.v1_0;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.headless.collaboration.dto.v1_0.AggregateRating;
import com.liferay.headless.collaboration.internal.dto.v1_0.util.AggregateRatingUtil;
import com.liferay.headless.collaboration.resource.v1_0.AggregateRatingResource;
import com.liferay.ratings.kernel.service.RatingsStatsLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Javier Gamarra
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/aggregate-rating.properties",
	scope = ServiceScope.PROTOTYPE, service = AggregateRatingResource.class
)
public class AggregateRatingResourceImpl
	extends BaseAggregateRatingResourceImpl {

	@Override
	public AggregateRating getAggregateRating(Long aggregateRatingId)
		throws Exception {

		return AggregateRatingUtil.toAggregateRating(
			_ratingsStatsLocalService.fetchStats(
				BlogsEntry.class.getName(), aggregateRatingId));
	}

	@Reference
	private RatingsStatsLocalService _ratingsStatsLocalService;

}