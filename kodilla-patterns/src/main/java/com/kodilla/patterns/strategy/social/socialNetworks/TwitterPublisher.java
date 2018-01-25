package com.kodilla.patterns.strategy.social.socialNetworks;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class TwitterPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Twitter inform: Post was published";
    }
}