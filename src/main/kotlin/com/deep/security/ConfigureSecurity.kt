package com.deep.security

import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.application.*


fun Application.configureSecurity() {
    JwtConfig.initialize("ktor-backend")
    install(Authentication) {
        jwt {
            verifier(JwtConfig.instance.verifier)
            validate {
                val claim = it.payload.getClaim(JwtConfig.CLAIM).asInt()
                if (claim != null) {
                    UserIdPrincipalForUser(claim)
                } else {
                    null
                }
            }
        }
    }

}


