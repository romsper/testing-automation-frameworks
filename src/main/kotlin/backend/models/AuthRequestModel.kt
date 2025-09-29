package backend.models

import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody

// This model is suitable for form-data requests

data class AuthRequestModel(
    var email: String? = null,
    var password: String? = null
) {
    fun toMap(): MutableMap<String, RequestBody> {
        val authRequest: MutableMap<String, RequestBody> = mutableMapOf()

        email?.let { email -> authRequest.put("email", email.toRequestBody(MultipartBody.FORM)) }
        password?.let { password -> authRequest.put("password", password.toRequestBody(MultipartBody.FORM)) }

        return authRequest
    }
}