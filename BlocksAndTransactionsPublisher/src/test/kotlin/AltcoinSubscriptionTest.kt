package au.com.nig.service

import com.satori.rtm.RtmClient
import com.satori.rtm.SubscriptionMode
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.internal.util.reflection.Whitebox
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AltcoinSubscriptionTest {

    @Mock private lateinit var client: RtmClient
    @Mock private lateinit var dispatcherMock: BlocksAndTransactionsDispatcher
    @InjectMocks private lateinit var altcoinSubscriber: AltcoinSubscription

    @Test
    fun should_make_sure_subscribe_create_a_subscription() {
        // GIVEN
        Whitebox.setInternalState(altcoinSubscriber, "client", client)

        // WHEN
        altcoinSubscriber.subscribe()

        // THEN
        verify(client, times(1)).createSubscription("altcoins", SubscriptionMode.SIMPLE, dispatcherMock)
        verify(client, times(1)).start()
    }
}