package au.com.nig.service

import com.satori.rtm.RtmClientBuilder
import com.satori.rtm.SubscriptionMode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AltcoinSubscription {

    private val endpoint = "wss://open-data.api.satori.com"
    private val appKey = "62EAaF8025fF2b6CA6A3fb0f8dCb2858"
    private val channelName = "altcoins"

    private val client = RtmClientBuilder(endpoint, appKey)
            .build()

    @Autowired private lateinit var dispatcher : BlocksAndTransactionsDispatcher

    fun subscribe() {
        client.createSubscription(channelName, SubscriptionMode.SIMPLE, dispatcher)
        client.start()
    }
}