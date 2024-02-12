package pl.autopay.parkology.data.network.dto.park

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Park(
    @SerializedName("activities")
    val activities: List<Activities>,
    @SerializedName("addresses")
    val addresses: List<Addresses>,
    @SerializedName("contacts")
    val contacts: Contacts,
    @SerializedName("description")
    val description: String,
    @SerializedName("designation")
    val designation: String,
    @SerializedName("directionsInfo")
    val directionsInfo: String,
    @SerializedName("directionsUrl")
    val directionsUrl: String,
    @SerializedName("entranceFees")
    val entranceFees: List<EntranceFees>,
    @SerializedName("entrancePasses")
    val entrancePasses: List<EntrancePasses>,
    @SerializedName("fullName")
    val fullName: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("images")
    val images: List<Images>,
    @SerializedName("latLong")
    val latLong: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("operatingHours")
    val operatingHours: List<OperatingHours>,
    @SerializedName("parkCode")
    val parkCode: String,
    @SerializedName("relevanceScore")
    val relevanceScore: Int,
    @SerializedName("states")
    val states: String,
    @SerializedName("topics")
    val topics: List<Topics>,
    @SerializedName("url")
    val url: String,
    @SerializedName("weatherInfo")
    val weatherInfo: String
) : Serializable {
    data class Contacts(
        @SerializedName("phoneNumbers")
        val phoneNumbers: List<PhoneNumbers>,
        @SerializedName("emailAddresses")
        val emailAddresses: List<EmailAddresses>
    ) : Serializable {
        data class PhoneNumbers(
            @SerializedName("phoneNumber")
            val phoneNumber: String,
            @SerializedName("description")
            val description: String,
            @SerializedName("extension")
            val extension: String,
            @SerializedName("type")
            val type: String
        ) : Serializable

        data class EmailAddresses(
            @SerializedName("emailAddress")
            val emailAddress: String,
            @SerializedName("description")
            val description: String
        ) : Serializable
    }

    data class EntranceFees(
        @SerializedName("cost")
        val cost: Int,
        @SerializedName("description")
        val description: String,
        @SerializedName("title")
        val title: String
    ) : Serializable

    data class EntrancePasses(
        @SerializedName("cost")
        val cost: Int,
        @SerializedName("description")
        val description: String,
        @SerializedName("title")
        val title: String
    ) : Serializable

    data class Images(
        @SerializedName("credit")
        val credit: String,
        @SerializedName("altText")
        val altText: String,
        @SerializedName("title")
        val title: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("caption")
        val caption: String,
        @SerializedName("url")
        val url: String
    ) : Serializable

    data class OperatingHours(
        @SerializedName("name")
        val name: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("standardHours")
        val standardHours: StandardHours,
        @SerializedName("exceptions")
        val exceptions: List<Exceptions>
    ) : Serializable {
        data class StandardHours(
            @SerializedName("sunday")
            val sunday: String,
            @SerializedName("monday")
            val monday: String,
            @SerializedName("tuesday")
            val tuesday: String,
            @SerializedName("wednesday")
            val wednesday: String,
            @SerializedName("thursday")
            val thursday: String,
            @SerializedName("friday")
            val friday: String,
            @SerializedName("saturday")
            val saturday: String
        ) : Serializable

        data class Exceptions(
            @SerializedName("name")
            val name: String,
            @SerializedName("startDate")
            val startDate: String,
            @SerializedName("endDate")
            val endDate: String,
            @SerializedName("exceptionHours")
            val exceptionHours: ExceptionHours?
        ) : Serializable {
            data class ExceptionHours(
                @SerializedName("sunday")
                val sunday: String?,
                @SerializedName("monday")
                val monday: String?,
                @SerializedName("tuesday")
                val tuesday: String?,
                @SerializedName("wednesday")
                val wednesday: String?,
                @SerializedName("thursday")
                val thursday: String?,
                @SerializedName("friday")
                val friday: String?,
                @SerializedName("saturday")
                val saturday: String?
            ) : Serializable
        }
    }

    data class Topics(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String
    ) : Serializable

    data class Activities(
        @SerializedName("id")
        val id: String,
        @SerializedName("name")
        val name: String
    ) : Serializable

    data class Addresses(
        @SerializedName("line1")
        val line1: String,
        @SerializedName("line2")
        val line2: String,
        @SerializedName("line3")
        val line3: String,
        @SerializedName("city")
        val city: String,
        @SerializedName("stateCode")
        val stateCode: String,
        @SerializedName("countryCode")
        val countryCode: String,
        @SerializedName("provinceTerritoryCode")
        val provinceTerritoryCode: String,
        @SerializedName("postalCode")
        val postalCode: String,
        @SerializedName("type")
        val type: String
    ) : Serializable
}
