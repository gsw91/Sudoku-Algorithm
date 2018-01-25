package com.kodilla.patterns.strategy.social.socialNetworks;

import com.kodilla.patterns.strategy.social.SocialPublisher;

public class SnapchatPublisher implements SocialPublisher {
    @Override
    public String share() {
        return "Your snap was added";
    }
}