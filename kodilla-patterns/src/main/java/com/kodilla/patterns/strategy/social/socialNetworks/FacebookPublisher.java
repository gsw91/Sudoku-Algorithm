package com.kodilla.patterns.strategy.social.socialNetworks;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class FacebookPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Post was published on facebook";
    }
}
