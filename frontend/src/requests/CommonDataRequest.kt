package requests

import org.w3c.dom.DocumentReadyState
import org.w3c.xhr.XMLHttpRequest

object CommonDataRequest {
    fun makeAsyncRequest(method: String, url: String, callback: () -> Unit, error: () -> Unit) {
        val request = XMLHttpRequest()
        request.onreadystatechange = {
            if(request.readyState == XMLHttpRequest.DONE) {
                if(request.status == 200.toShort()) {
                    callback()
                } else {
                    error()
                }
            }
        }
        request.open(method, url, true)
        request.send()
    }
}