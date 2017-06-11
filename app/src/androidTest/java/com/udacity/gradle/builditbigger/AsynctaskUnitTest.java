package com.udacity.gradle.builditbigger;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by srv_twry on 11/6/17.
 */

public class AsynctaskUnitTest implements FetchJokeAsyncTask.AsyncTaskCompletionListenerTest{

    private final CountDownLatch mSignal = new CountDownLatch(1);

    @Test
    public void testJokeRetriever() {
        new FetchJokeAsyncTask(this).execute();
        try {
            boolean success = mSignal.await(10, TimeUnit.SECONDS);
            if (!success) {
                fail("Test timed out, make sure the server is actually running.");
            }
        } catch (InterruptedException e) {
            fail();
        }
    }

    @Override
    public void onResponse(boolean isSuccess, String result) {
        assertTrue(isSuccess && result != null && result.length() > 0);
        mSignal.countDown();
    }
}
