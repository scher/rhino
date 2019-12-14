package com.bulldozer.domain.site;

import com.bulldozer.common.Direction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SiteTest {

    private Site site;
    private SiteBlock blockMock00;
    private SiteBlock blockMock01;
    private SiteBlock blockMock10;
    private SiteBlock blockMock11;

    @BeforeEach
    void setup() {
        blockMock00 = mock(SiteBlock.class);
        blockMock01 = mock(SiteBlock.class);
        blockMock10 = mock(SiteBlock.class);
        blockMock11 = mock(SiteBlock.class);
        SiteBlock[][] blocks = {
                {blockMock00, blockMock01},
                {blockMock10, blockMock11}
        };
        site = new Site(blocks);
    }

    @Test
    void move() {
        Assertions.assertEquals(blockMock00, site.move(Direction.EAST));
        Assertions.assertEquals(blockMock01, site.move(Direction.EAST));
        Assertions.assertEquals(blockMock11, site.move(Direction.SOUTH));
        Assertions.assertEquals(blockMock10, site.move(Direction.WEST));
        Assertions.assertEquals(blockMock00, site.move(Direction.NORTH));
        Assertions.assertEquals(blockMock10, site.move(Direction.SOUTH));
        Assertions.assertEquals(blockMock11, site.move(Direction.EAST));
    }

    @Test
    void testInitialPosition() {
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> site.move(Direction.WEST));
        setup();
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> site.move(Direction.SOUTH));
        setup();
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class,
                () -> site.move(Direction.NORTH));
    }

    /*
    00 01
    10 11
     */
    @Test
    void getUnclearedBlocksAmount() {
        when(blockMock00.isCleared()).thenReturn(true);
        when(blockMock11.isCleared()).thenReturn(true);
        when(blockMock01.isCleared()).thenReturn(true);
        when(blockMock10.isCleared()).thenReturn(false);

        Assertions.assertEquals(1, site.getUnclearedBlocksAmount());
    }

    @Test
    void getProtectedTreeDestroyedAmount() {
        when(blockMock00.isProtectedTreeDestroyed()).thenReturn(true);
        when(blockMock11.isProtectedTreeDestroyed()).thenReturn(false);
        when(blockMock01.isProtectedTreeDestroyed()).thenReturn(false);
        when(blockMock10.isProtectedTreeDestroyed()).thenReturn(false);

        Assertions.assertEquals(1, site.getProtectedTreeDestroyedAmount());
    }
}