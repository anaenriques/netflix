package com.netflix.utils.constants;

// TODO: Auto-generated Javadoc
/**
 * The Class RestConstants.
 */
public class RestConstants {

	/** The Constant APPLICATION_NAME. */
	public static final String APPLICATION_NAME = "/netflix";
	
	/** The Constant API_VERSION_1. */
	public static final String API_VERSION_1 = "/v1";
	
	/** The Constant SUCCESS. */
	public static final String SUCCESS = "Success";

	/** The Constant RESOURCE_CATEGORY. */
	public static final String RESOURCE_CATEGORY = "/categories";
	
	/** The Constant RESOURCE_TV_SHOW. */
	public static final String RESOURCE_TV_SHOW = "/tv-shows";
	
	/** The Constant RESOURCE_SEASON. */
	public static final String RESOURCE_SEASON = "/tv-shows/{tvShowId}/seasons";
	
	/** The Constant RESOURCE_CHAPTER. */
	public static final String RESOURCE_CHAPTER = "/tv-shows/{tvShowId}/seasons/{seasonNumber}/chapters";
	
	/** The Constant RESOURCE_ID. */
	public static final String RESOURCE_ID = "/{id}";
	
	/** The Constant RESOURCE_NUMBER. */
	public static final String RESOURCE_NUMBER = "/{number}";
	
	/** The Constant PARAMETER_CATEGORY. */
	public static final String PARAMETER_CATEGORY = "categories";

	/**
	 * Instantiates a new rest constants.
	 */
	private RestConstants() {
		throw new IllegalStateException("Utility Class");
	}

}

