import com.example.interaface.model.LoginData
import com.example.interaface.model.waterPermission
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface secondRequestService {
    @GET("waterPermissions")
    suspend fun fetchWaterPermissions(@Header("Token") token: String?): Response<Any>
}
