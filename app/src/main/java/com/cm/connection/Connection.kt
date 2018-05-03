package com.cm.connection

import com.cm.Utilities.Utility
import com.cm.Utilities.shortToast
import com.dewarder.akommons.isConnectedToMobile
import com.dewarder.akommons.isConnectedToWifi
import com.omnitech.elunda.proto.ClientRequest
import com.omnitech.elunda.proto.ServerResponse
import okhttp3.*
import java.io.IOException

/**
 * Created by magicwand on 4/18/2018.
 */
object Connection {

    private val httpLink = Utility.ONLINE_DATA_LINK
    private val client = OkHttpClient()

    private val defaultOnErrorHandler: (String) -> Unit = { p -> Utility.application.shortToast(p) }


    fun postDataAsync(request: ClientRequest,
                      onSuccess: (ServerResponse) -> Unit,
                    onError: (String) -> Unit = defaultOnErrorHandler,
                     whenDone: () -> Unit = {}) {
//
//        if (!Globals.application.isConnectedToMobile &&
//                !Globals.application.isConnectedToWifi) {
//            doSafely { onError("No Network Connection") }
//            whenDone()
//            return
//        }
//
//        val requestBody = RequestBody
//                .create(MediaType.parse("application/binary"), request.encode())
//
//
//        val httpReq = Request.Builder()
//                .url(Connection.httpLink)
//                .post(requestBody)
//                .build()
//
//
//        Connection.client.newCall(httpReq).enqueue(object : Callback {
//            override fun onFailure(call: Call, e: IOException) {
//                try {
//                    onError("Error while making request[$request]. ${e.message}")
//                } finally {
//                    whenDone()
//                }
//            }
//
//            override fun onResponse(call: Call, response: Response) {
//                try {
//                    if (response.isSuccessful) {
//                        try {
//                            decodeResponse(response, request, onSuccess, onError)
//                        } catch (x: Exception) {
//                            x.printStackTrace()
//                            onError.invoke("Error Decoding Response for $request : ${x.message}")
//                        }
//                    } else {
//                        onError.invoke("Error while making request[$request]. ${response.message()}")
//                    }
//                } finally {
//                    whenDone()
//                }
//            }
//
//        })


    }


//    fun post(request: ClientRequest): ServerResponse {
//
//        if (!Globals.application.isConnectedToMobile &&
//                !Globals.application.isConnectedToWifi) {
//            throw RuntimeException("No Network Connection for $request")
//        }
//
//        val requestBody = RequestBody.create(MediaType.parse("application/binary"), request.encode())
//
//
//        val httpReq = Request.Builder()
//                .url(Connection.httpLink)
//                .post(requestBody)
//                .build()
//
//
//        val newCall = Connection.client.newCall(httpReq)
//
//        val response = newCall.execute()
//
//
//
//        if (!response.isSuccessful) {
//            throw RuntimeException("Error while making request on server[${response.message()}] for $request")
//        }
//
//        val body = response.body() ?: throw RuntimeException("Server did not send any data with response: $request")
//
//
//        val serverRepose = try {
//            ServerResponse.ADAPTER.decode(body.byteStream())
//        } catch (x: Exception) {
//            throw RuntimeException("Error decoding server response for $request:", x)
//        }
//
//        if (serverRepose.isSuccessful() || serverRepose.isDuplicate()) {
//            return serverRepose
//        } else {
//            throw ServerErrorResponse("ServerError:[${serverRepose.message}] for ${request.request}")
//        }
//
//    }
//
//    private fun decodeResponse(response: Response,
//                               request: ClientRequest,
//                               onSuccess: (ServerResponse) -> Unit,
//                               onError: (String) -> Unit) {
//        val body = response.body()
//
//
//        if (body != null) {
//            val serverRepose = ServerResponse.ADAPTER.decode(body.byteStream())
//            if (serverRepose.isSuccessful()) {
//                onSuccess.invoke(serverRepose)
//            } else {
//                onError.invoke("ServerError(${request.request}): ${serverRepose.message}")
//            }
//        } else {
//            onError.invoke("Error while Downloading ${request.request}")
//        }
//    }
//
//    fun ServerResponse.isSuccessful(): Boolean = this.status == ServerResponse.STATUS.SUCCESS
//    fun ServerResponse.isDuplicate(): Boolean = this.status == ServerResponse.STATUS.DUPLICATE
//
//
//}
//
//fun clientRequest(cr: ClientRequest.RequestType, config: (ClientRequest.Builder.() -> Unit)? = null): ClientRequest.Builder {
//    val user = DbUtility.fetchFirst(User::class.java)
//    if (user != null) {
//        val r = ClientRequest.Builder()
//                .request(cr)
//                .username(user.phoneNumber)
//                .password(user.password)
//
//        config?.let { r.config() }
//
//        return r
//    } else {
//        throw RuntimeException("No User Found In Data Base")
//    }
//
//
}

//class ServerErrorResponse(string: String) : java.lang.RuntimeException(string)
//
//class DuplicateItemException(serverErrorResponse: ServerErrorResponse)
//    : java.lang.RuntimeException(serverErrorResponse.message)