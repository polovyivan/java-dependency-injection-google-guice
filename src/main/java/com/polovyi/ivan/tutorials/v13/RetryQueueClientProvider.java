package com.polovyi.ivan.tutorials.v13;

import com.google.inject.Provider;

public class RetryQueueClientProvider implements Provider<RetryQueueClient> {

    @Override
    public RetryQueueClient get() {
        return new RetryQueueClient();
    }
}
