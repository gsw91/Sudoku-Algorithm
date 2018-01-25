package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.socialNetworks.SnapchatPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User george = new Millenials("George");
        User daniel = new YGeneration("Daniel");
        User henry = new ZGeneration("Henry");
        //When
        String georgeShares = george.sharePost();
        String danielShares = daniel.sharePost();
        String henryShares = henry.sharePost();
        //Then
        Assert.assertEquals("Post was published on facebook", georgeShares);
        Assert.assertEquals("Your snap was added", henryShares);
        Assert.assertEquals("Twitter inform: Post was published", danielShares);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User george = new Millenials("George");
        User daniel = new YGeneration("Daniel");
        //When
        george.setSocialPublisher(new SnapchatPublisher());
        String georgeShares = george.sharePost();
        daniel.setSocialPublisher(new SnapchatPublisher());
        String danielShares = daniel.sharePost();;
        //Then
        Assert.assertEquals("Your snap was added", georgeShares);
        Assert.assertEquals("Your snap was added", danielShares);
    }

}
