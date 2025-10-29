package com.adrienmandroid.composecv.model.response

fun <H, P> List<P>.toResponse(header: H) = Response(header, this)

fun <P> List<P>.toResponse() = BasicResponse(null, this)