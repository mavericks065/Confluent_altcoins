package au.com.nig.service

import au.com.nig.model.AltcoinTransaction
import au.com.nig.model.Transaction
import com.satori.rtm.SubscriptionAdapter
import com.satori.rtm.model.AnyJson
import com.satori.rtm.model.SubscriptionData
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class BlocksAndTransactionsDispatcher : SubscriptionAdapter() {

    private val logger = LoggerFactory.getLogger("BlocksAndTransactionsDispatcher")

    override fun onSubscriptionData(data: SubscriptionData?) {
        data!!.messages.map { transform(it) }
    }

    private fun transform(msg: AnyJson): Transaction? {
        logger.info(msg.toString())
        val transaction = msg.convertToType(AltcoinTransaction::class.java)
        logger.info(transaction.toString())
        return null
    }
}