package com.adrienmandroid.composecv.model.response

fun <H, P> List<P>.toResponse(header: H?) = Response.Success(header, this)

fun <P> List<P>.toResponse() = Response.Success(Unit, this)