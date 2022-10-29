package com.company.controller.ai;

import com.company.model.MoveDto;

public interface Ai {

    String getNextPosition(MoveDto moveDto);

}
