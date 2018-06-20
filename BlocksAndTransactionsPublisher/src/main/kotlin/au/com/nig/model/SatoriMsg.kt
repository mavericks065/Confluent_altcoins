package au.com.nig.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.sql.Timestamp

open class SatoriMsg {
    @JsonProperty("type") lateinit var type: String
    @JsonProperty("txid") lateinit var id: String
    @JsonProperty("received_at") lateinit var receivedAt : Timestamp
    @JsonProperty("network_fee") lateinit var netWorkFee : String
    @JsonProperty("amount_received") lateinit var amountReceived : String
    @JsonProperty("inputs") lateinit var inputs : List<String>

    override fun toString(): String {
        return "Transaction(type='$type')"
    }

}