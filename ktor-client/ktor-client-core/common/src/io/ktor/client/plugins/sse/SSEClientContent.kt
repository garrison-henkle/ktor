/*
 * Copyright 2014-2023 JetBrains s.r.o and contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package io.ktor.client.plugins.sse

import io.ktor.http.*
import io.ktor.http.content.*
import io.ktor.utils.io.*
import kotlin.time.*

@InternalAPI
public class SSEClientContent(
    headers: HeadersBuilder,
    public val reconnectionTime: Duration,
    public val showCommentEvents: Boolean,
    public val showRetryEvents: Boolean,
) : OutgoingContent.NoContent() {

    override val headers: Headers = headers.apply {
        append(HttpHeaders.Accept, ContentType.Text.EventStream)
        append(HttpHeaders.CacheControl, "no-store")
    }.build()

    override fun toString(): String = "SSEClientContent"
}
