package com.deep.security

import io.ktor.util.*
import java.nio.charset.Charset
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

private val SECRET_KEY = "241607241607"
private val ALGORITHM = "HmacSHA1"

private val HSAH_KEY = hex(SECRET_KEY)
private val HMAC_KEY = SecretKeySpec(HSAH_KEY, ALGORITHM)

fun hash(password: String): String {
    val hMac = Mac.getInstance(ALGORITHM)
    hMac.init(HMAC_KEY)
    return hex(hMac.doFinal(password.toByteArray(Charsets.UTF_8)))
}