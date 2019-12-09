package com.bulldozer.domain.site;

import com.bulldozer.common.Direction;

public interface TraversableSite {
    ClearableBlock move(Direction direction);
}
