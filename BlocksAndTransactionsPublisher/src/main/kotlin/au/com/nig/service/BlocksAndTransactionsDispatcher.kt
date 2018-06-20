package au.com.nig.service

import au.com.nig.model.AltcoinTransaction
import au.com.nig.model.Transaction
import com.satori.rtm.SubscriptionAdapter
import com.satori.rtm.model.AnyJson
import com.satori.rtm.model.SubscriptionData
import org.springframework.stereotype.Service

@Service
class BlocksAndTransactionsDispatcher : SubscriptionAdapter() {

    override fun onSubscriptionData(data: SubscriptionData?) {
        data!!.messages.map { transform(it) }
    }

    private fun transform(msg: AnyJson): Transaction? {
        println(msg)
        val transaction = msg.convertToType(AltcoinTransaction::class.java)
        println(transaction.toString())
        return null
    }
}