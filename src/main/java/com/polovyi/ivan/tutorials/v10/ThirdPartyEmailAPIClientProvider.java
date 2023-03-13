package com.polovyi.ivan.tutorials.v10;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public class ThirdPartyEmailAPIClientProvider implements Provider<ThirdPartyEmailAPIClient> {

    private final String apiKey;

    @Inject
    public ThirdPartyEmailAPIClientProvider(@Named("apiKey") String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public ThirdPartyEmailAPIClient get() {
        return new ThirdPartyEmailAPIClient(apiKey);
    }
}
