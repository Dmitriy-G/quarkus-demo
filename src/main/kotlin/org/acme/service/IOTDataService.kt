package org.acme.service

import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class IOTDataService {
    fun collect(data: String): String {
        return "data received"
    }
}
