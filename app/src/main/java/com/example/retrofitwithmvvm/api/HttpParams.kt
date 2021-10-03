package com.example.retrofitwithmvvm.api

object HttpParams {
    const val PER_PAGE = "per_page"
    const val PAGE = "page"
    const val CATEGORIES = "categories"
    const val ID = "id"
    const val SEARCH = "search"
    const val POST = "post"
    const val API_CATEGORIES = "wp-json/wp/v2/categories?page=1&"
    const val API_POSTS = "wp-json/wp/v2/posts?per_page=10&_embed=true"
    const val API_FEATURED_POSTS = "wp-json/wp/v2/posts?per_page=10&_embed=true&sticky=true"
    const val API_POST_DETAILS = "wp-json/wp/v2/posts/{id}?&_embed=true"
    const val API_COMMENT = "wp-json/wp/v2/comments?"
    const val TOTAL_PAGE = "x-wp-totalpages"
    const val COMMENT_AUTHOR_NAME = "author_name"
    const val COMMENT_AUTHOR_EMAIL = "author_email"
    const val COMMENT_CONTENT = "content"
}
