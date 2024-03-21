import com.example.interaface.model.LoginData
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("login")
    suspend fun loginUser(
        @Field("u") userName: String,
        @Field("p") password: String
    ): Response<LoginData>

    @GET("gestione/api/waterPermissions")
    suspend fun fetchWaterPermissions(
        @Header("Authorization") token: String
    ): Response <WaterPermissionsData>
}