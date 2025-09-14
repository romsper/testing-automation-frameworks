package backend.models

import okhttp3.MultipartBody
import okhttp3.RequestBody

// This model is suitable for form-data requests

data class AuthRequestModel(
    var email: String? = null,
    var password: String? = null
) {
    fun toMap(): MutableMap<String, RequestBody> {
        val authRequest: MutableMap<String, RequestBody> = mutableMapOf()

        email?.let { email -> authRequest.put("email", RequestBody.create(MultipartBody.FORM, email)) }
        password?.let { password -> authRequest.put("password", RequestBody.create(MultipartBody.FORM, password)) }

        return authRequest
    }
}